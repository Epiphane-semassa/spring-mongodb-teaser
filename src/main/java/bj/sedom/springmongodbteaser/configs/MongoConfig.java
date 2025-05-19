package bj.sedom.springmongodbteaser.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.Collections;

@Configuration
@RequiredArgsConstructor
public class MongoConfig {

    private final MongoDatabaseFactory mongoDatabaseFactory;

    @Bean
    public MappingMongoConverter mappingMongoConverter(MongoMappingContext context) {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDatabaseFactory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, context);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        converter.setCustomConversions(new MongoCustomConversions(Collections.emptyList()));
        converter.afterPropertiesSet();
        return converter;
    }

}
