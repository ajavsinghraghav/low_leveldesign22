package dev.tarun.productservice.inheritancedemo.tableperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//when we will try to fetch user details
//it will make a fetch query from all tables with union
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
