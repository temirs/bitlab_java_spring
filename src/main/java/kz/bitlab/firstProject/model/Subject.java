package kz.bitlab.firstProject.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "subject")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String Name;

    @Column(name = "CABINET")
    private int Cabinet;

    @Column(name = "CREDIT")
    private int Credit;

}
