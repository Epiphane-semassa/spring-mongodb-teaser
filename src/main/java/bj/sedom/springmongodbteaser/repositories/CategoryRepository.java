package bj.sedom.springmongodbteaser.repositories;

import bj.sedom.springmongodbteaser.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}