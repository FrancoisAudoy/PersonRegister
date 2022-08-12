package fr.francoisaudoy.personregister.constraint.validator;

import fr.francoisaudoy.personregister.constraint.PersonConstraint;
import fr.francoisaudoy.personregister.exception.*;
import fr.francoisaudoy.personregister.model.PersonDto;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.regex.Pattern;

public class PersonValidator implements ConstraintValidator<PersonConstraint, PersonDto> {

    private static final int PHONE_NUMBER_SIZE = 10;

    @Setter
    @NotNull
    @Value("${personRegister.validCountry}")
    private String validCountry;

    @Setter
    @NotNull
    @Value("${personRegister.minimalAge}")
    private Short minimalAge;

    private final String phoneNumberPattern = "[0-9]{10}";

    @SneakyThrows
    @Override
    public boolean isValid(PersonDto personDto, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(personDto.getUserName()))
            throw new InvalidUserNameException("user name field can't be empty");
        if (StringUtils.isBlank(personDto.getCountry())
                || !validCountry.equalsIgnoreCase(personDto.getCountry()))
            throw new InvalidCountryException("country field can't be null or different of " + validCountry);

        if (personDto.getBirthdate() == null
                || minimalAge > getAge(personDto.getBirthdate()))
            throw new InvalidBirthdateException("birthdate field can't be null and age must be equal or greater than " + minimalAge);

        if (personDto.getPhoneNumber() != null
                && !Pattern.matches(phoneNumberPattern, personDto.getPhoneNumber()))
            throw new InvalidPhoneNumberException("phone number size has to be of 10 digit");

        if (personDto.getGender() != null
                && StringUtils.isBlank(personDto.getGender()))
            throw new InvalidGenderException("if field gender is specify then it can not be empty");

        return true;
    }

    private Long getAge(Date birthdate) throws InvalidBirthdateException {

        LocalDateTime birthdateDateTime = LocalDateTime.ofInstant(birthdate.toInstant(), ZoneId.systemDefault());
        LocalDateTime today = LocalDateTime.now(ZoneId.systemDefault());

        if (today.isBefore(birthdateDateTime))
            throw new InvalidBirthdateException("birthdate can't be in the future");

        return birthdateDateTime.until(today, ChronoUnit.YEARS);
    }

}
