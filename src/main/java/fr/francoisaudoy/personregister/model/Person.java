package fr.francoisaudoy.personregister.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String userName;
    private Date birthdate;
    private String country;
    private String phoneNumber;
    private String gender;
}
