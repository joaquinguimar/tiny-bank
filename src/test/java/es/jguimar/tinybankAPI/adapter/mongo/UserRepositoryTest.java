package es.jguimar.tinybankAPI.adapter.mongo;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import es.jguimar.tinybankAPI.domain.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class UserRepositoryTest {

  public static final String NAME_SAVED = "name saved";

  @Autowired
  UserMongoRepository userMongoRepository;

  @Autowired
  MongoTemplate mongoTemplate;


  @Test
  public void findByName_shouldReturnOK() {
    // given
    DBObject objectToSave = BasicDBObjectBuilder.start().add("name", NAME_SAVED).get();

    // when
    mongoTemplate.save(objectToSave, "user");

    Optional<User> user = userMongoRepository.findByName(NAME_SAVED);

    // then
    assertThat(user.get().getName()).isEqualTo(NAME_SAVED);
  }
}
