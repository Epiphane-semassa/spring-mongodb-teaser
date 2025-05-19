package bj.sedom.springmongodbteaser.repositories;

import bj.sedom.springmongodbteaser.models.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<Tag, String> {
    // Custom query methods can be defined here if needed
}
