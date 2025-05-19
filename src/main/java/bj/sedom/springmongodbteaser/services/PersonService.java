package bj.sedom.springmongodbteaser.services;

import bj.sedom.springmongodbteaser.models.Person;
import bj.sedom.springmongodbteaser.schemas.PersonSchema;
import com.mongodb.client.result.InsertOneResult;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonSchema personSchema;


    //@PostConstruct
    public void init() {
        System.out.println("\n");

        System.out.println("PersonService initialized with collection: " + personSchema.getPersonMongoCollection().getNamespace());
        System.out.println("Collection exists and is ready for use.");

        //Insert a person to test the schema
        Person person = new Person("Luke", 23, "The Force", true);
        Document personDocument = new Document();
        personDocument.append("firstname", person.getFirstname());
        personDocument.append("age", person.getAge());
        personDocument.append("theForce", person.getTheForce());
        personDocument.append("useTheForce", person.getUseTheForce());

        // Insert the document into the collection
        InsertOneResult personResult = personSchema.getPersonMongoCollection().insertOne(personDocument);
        // display person inserted all infos include the id
        //System.out.println("Inserted person: " + personDocument.toJson());
        System.out.println("Inserted person: " + personSchema.getPersonMongoCollection().find());

        System.out.println("\n");
    }

}
