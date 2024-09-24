package kz.bitlab.firstProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "AGE")
    private int age;

    @Column(name = "GPA")
    private double gpa;

    @Column(name = "BIO", columnDefinition = "text")
    private String bio;

    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    private City city;

    @ManyToMany
    private List<Subject> subjects = new ArrayList<>();
}
