package dev.tarun.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`order`")
public class Order extends BaseModel{
    @ManyToMany
    @JoinTable(
            name="product_orders", //what should be the join table name
            joinColumns = @JoinColumn(name="order_id"), //what should be the column name in join table of order
            inverseJoinColumns = @JoinColumn(name="product_id")  //what should be the column name in join table of other column
    )
    private List<Product> product;
}
