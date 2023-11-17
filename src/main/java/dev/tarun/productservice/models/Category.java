package dev.tarun.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseModel{
    private String name;
    //if we do not use mappedBy spring thought that there are two different relation, so it
    // will create a column of category_id in product table and also a category_products table will be created .
    @OneToMany(mappedBy = "category") //it should be in OneToMany side
    private List<Product> products;
    //this is the same relation being mapped by category attribute in the other(Product) class
}
/*
class Group{
m:m
List<User> members;
m:m
List<User> admins;
m:1
User creator;
}
 */