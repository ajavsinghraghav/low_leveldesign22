package dev.tarun.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass //to tell ORM that attribute of this class must be present in all of the child classes
public class BaseModel {
    @Id //to make it primary key
    @GeneratedValue(generator = "uuidgenerator")
    @GenericGenerator(name="uuidgenerator",strategy = "uuid2")
    @Column(name="id",columnDefinition="binary(16)",nullable = false,updatable = false)
    private UUID uuid;
}
