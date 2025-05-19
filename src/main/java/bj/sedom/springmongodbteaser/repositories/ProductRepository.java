package bj.sedom.springmongodbteaser.repositories;

import bj.sedom.springmongodbteaser.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByCategory_Id(String category_id);

    @Query(value = "{}", fields = "{'name': 1, 'price': 1, 'category': 1, 'tags': 1}")
    List<Product> findAllWithTags();

    List<Product> findByTags_Id(String tags_id);

}