package bj.sedom.springmongodbteaser.repositories;

import bj.sedom.springmongodbteaser.models.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface GroceryItemRepository extends MongoRepository<GroceryItem, String> {
    // Custom query methods can be defined here if needed
    // For example, findByName(String name) or findByPriceLessThan(double price)

    // You can also use Spring Data MongoDB's query derivation feature to create queries

    @Query("{name:'?0'}")
    GroceryItem findItemByName(String name);

    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<GroceryItem> findAllByCategory(String category);

    public long count();

}
