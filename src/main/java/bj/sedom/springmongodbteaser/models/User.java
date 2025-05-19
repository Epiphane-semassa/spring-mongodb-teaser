package bj.sedom.springmongodbteaser.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @MongoId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;

    private String email;

    private String phone;

    private String address;

    public User(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public static User[] RandomUsers(int count) {
        User[] users = new User[count];
        for (int i = 0; i < count; i++) {
            users[i] = new User("Name" + i, "email" + i + "@example.com", "123456789" + i, "Address" + i);
        }
        return users;
    }

}