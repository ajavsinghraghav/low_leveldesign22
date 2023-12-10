package dev.tarun.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseModel{
    //for the non-collection attribute,by default the fetch type is eager.
    private String name;
    //if we do not use mappedBy, spring thought that there are two different relation, so it
    // will create a column of category_id in product table and also a category_products table will be created .

    //for the collection(List) attribute,by default the fetch type is Lazy
    @OneToMany(mappedBy = "category") //this "mappedBy" should be in OneToMany side//so there will not be column on both sides
    @Fetch(FetchMode.SUBSELECT)//two db calls will happen, to fetch the category and the all the products associated with the category in one go
    //subselect will only work if it is a list/multivalued attribute
    private List<Product> products=new ArrayList<>();
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