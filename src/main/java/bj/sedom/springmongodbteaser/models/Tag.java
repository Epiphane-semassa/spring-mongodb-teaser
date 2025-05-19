package bj.sedom.springmongodbteaser.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "tags")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tag {

    @MongoId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;

    public Tag(String name) {
        this.name = name;
    }

}