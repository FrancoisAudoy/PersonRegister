package fr.francoisaudoy.personregister.model;

import lombok.*;

import java.util.Date;

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
}
