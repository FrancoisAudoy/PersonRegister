package fr.francoisaudoy.personregister.model;

import fr.francoisaudoy.personregister.model.entity.PersonEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Data
public class PersonDto {

    private String userName;
    private String birthdate;
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
