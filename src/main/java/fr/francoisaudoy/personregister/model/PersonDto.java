package fr.francoisaudoy.personregister.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import fr.francoisaudoy.personregister.constraint.PersonConstraint;
import fr.francoisaudoy.personregister.model.entity.PersonEntity;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Data
@EqualsAndHashCode
@PersonConstraint
public class PersonDto {

    private String userName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date birthdate;
    private String country;
    private String phoneNumber;
    private String gender;

    public PersonEntity toEntity() {
        final PersonEntity entity = new PersonEntity();
        entity.setUserName(userName);
        entity.setBirthdate(birthdate);
        entity.setCountry(country);
        entity.setPhoneNumber(phoneNumber);
        entity.setGender(gender);
        return entity;

    }
}
