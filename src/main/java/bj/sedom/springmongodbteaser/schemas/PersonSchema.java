package bj.sedom.springmongodbteaser.schemas;

import bj.sedom.springmongodbteaser.models.Person;
import com.mongodb.client.MongoCollection;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoJsonSchemaCreator;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.core.schema.MongoJsonSchema;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonSchema {

    private final MongoTemplate mongoTemplate;
    private final MongoOperations mongoOperations;
    private final MongoMappingContext mongoMappingContext;

    @Getter
    private MongoCollection<Document> personMongoCollection;

    @PostConstruct
    public void init() {
        MongoJsonSchema schema = MongoJsonSchemaCreator
                //.create(mongoOperations.getConverter())
                //set encrypted fields
                .create(mongoMappingContext)
                .filter(MongoJsonSchemaCreator.encryptedOnly())
                //create schema for Person class
                .createSchemaFor(Person.class);

        if (!mongoTemplate.collectionExists("persons")) {
            personMongoCollection = mongoTemplate.createCollection("persons", CollectionOptions.empty().schema(schema));
        } else {
            personMongoCollection = mongoTemplate.getCollection("persons");
        }
    }

}
