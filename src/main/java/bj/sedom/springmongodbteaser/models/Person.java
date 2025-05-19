package bj.sedom.springmongodbteaser.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Transient;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Encrypted;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection = "persons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Encrypted(keyId = "xKVup8B1Q+CkHaVRx+qa+g==", algorithm = "AEAD_AES_256_CBC_HMAC_SHA_512-Random")
public class Person {

    @MongoId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String firstname;

    private int age;

    @Encrypted(algorithm = "AEAD_AES_256_CBC_HMAC_SHA_512-Random")
    private String theForce;

    @Transient
    private Boolean useTheForce;

    public Person(String firstname, int age, String theForce, Boolean useTheForce) {
        this.firstname = firstname;
        this.age = age;
        this.theForce = theForce;
        this.useTheForce = useTheForce;
    }

}
