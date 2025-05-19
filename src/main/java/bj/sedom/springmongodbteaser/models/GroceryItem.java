package bj.sedom.springmongodbteaser.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection = "grocery_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroceryItem {

    @MongoId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;

    private int quantity;

    private String category;

    public GroceryItem(String name, int quantity, String category) {
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }

}
