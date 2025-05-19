package bj.sedom.springmongodbteaser.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    @MongoId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;

    private double price;

    @DBRef(lazy = true) // Lazy loading for the referenced category
    private Category category;

    @DBRef
    private Set<Tag> tags = new HashSet<>();

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(String name, double price, Category category, Set<Tag> tags) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.tags = tags;
    }

}