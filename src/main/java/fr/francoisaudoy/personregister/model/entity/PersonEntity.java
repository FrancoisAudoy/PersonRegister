package fr.francoisaudoy.personregister.model.entity;

import fr.francoisaudoy.personregister.model.PersonDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "person")
@ToString
@EqualsAndHashCode
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String userName;
    private String birthdate;
    private String country;
    private String phoneNumber;
    private String gender;

    public PersonDto toDto() {
        PersonDto dto = new PersonDto();
        dto.setUserName(userName);
        dto.setBirthdate(birthdate);
        dto.setCountry(country);
        dto.setPhoneNumber(phoneNumber);
        dto.setGender(gender);
        return dto;
    }
}
