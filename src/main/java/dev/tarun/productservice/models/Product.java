package dev.tarun.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    @ManyToOne
    private Category category;
    private double price;
}
//Lombok is used for -
//-@Getter @Setter @AllArgConstructor @NoArgConstructor @Builder

