package kz.bitlab.firstProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cities")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CODE")
    private String code;

    @Column(name = "POPULATION")
    private int population;
}
