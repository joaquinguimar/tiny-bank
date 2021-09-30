package es.jguimar.tinybankAPI.infrastructure.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Configuration of embedded mongodb conditionaly
 */
@Configuration
@Profile({"!dev"})
@EnableAutoConfiguration(exclude= EmbeddedMongoAutoConfiguration.class)
public class EmbeddedMongoConfig {

}