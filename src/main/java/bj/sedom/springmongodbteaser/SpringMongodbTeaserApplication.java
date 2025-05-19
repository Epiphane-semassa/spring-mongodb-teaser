package bj.sedom.springmongodbteaser;

import bj.sedom.springmongodbteaser.services.BulkLoaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@RequiredArgsConstructor
public class SpringMongodbTeaserApplication implements CommandLineRunner {

    private final BulkLoaderService bulkLoaderService;

    public static void main(String[] args) {
        SpringApplication.run(SpringMongodbTeaserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //testBulkInsertUsers();
    }

    public void testBulkInsertUsers() {
        System.out.println("Starting bulk insert...");
        int count = 1000;
        int insertedCount = bulkLoaderService.bulkInsertUsers(count);
        System.out.println("Inserted " + insertedCount + " users.");
        System.out.println("Bulk insert completed...");
    }

}
