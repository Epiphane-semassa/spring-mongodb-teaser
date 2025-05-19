package bj.sedom.springmongodbteaser.services;

import bj.sedom.springmongodbteaser.models.User;
import com.mongodb.WriteConcern;
import com.mongodb.bulk.BulkWriteResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class BulkLoaderService {

    private final MongoTemplate mongoTemplate;


    public int bulkInsertUsers(int count) {
        System.out.println("Dropping collection...");

        mongoTemplate.dropCollection(User.class);
        System.out.println("Dropped!");

        Instant start = Instant.now();
        mongoTemplate.setWriteConcern(WriteConcern.W1.withJournal(true));

        User[] users = User.RandomUsers(count);
        BulkOperations bulkInsertion = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, User.class);
        for (User user : users) {
            bulkInsertion.insert(user);
            System.out.println("USER INSERTED: " + user.getEmail());
        }

        BulkWriteResult bulkWriteResult = bulkInsertion.execute();

        System.out.println("Bulk insert of " + bulkWriteResult.getInsertedCount() + " documents completed in " + Duration.between(start, Instant.now()).toMillis() + " milliseconds");

        return bulkWriteResult.getInsertedCount();
    }

}
