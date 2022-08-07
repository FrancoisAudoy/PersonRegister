package fr.francoisaudoy.personregister.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "person")
@ToString
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
}
