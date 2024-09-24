package kz.bitlab.firstProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long id;
    private String name;
    private String description;
    private double price;


}
