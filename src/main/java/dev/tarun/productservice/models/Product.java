package dev.tarun.productservice.models;

import jakarta.persistence.*;
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
    @ManyToOne(cascade={CascadeType.PERSIST}) //so that you don't need to save the category object using repo class
    // before creating product object, it will automatically save it, else it will make DB calls twice

    @JoinColumn(name="category") // what should be the name of category column in product table
    private Category category;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Price price;
}
//Lombok is used for -
//-@Getter @Setter @AllArgConstructor @NoArgConstructor @Builder

