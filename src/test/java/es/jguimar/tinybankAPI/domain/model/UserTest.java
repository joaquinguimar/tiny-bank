package es.jguimar.tinybankAPI.domain.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class UserTest {

    @Test
    public void builderOK() {
        User result = User.builder().build();

        assertThat(result).isNotNull();
    }

    @Test
    public void newOK() {
        User result = new User("id", "name", "pass");
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo("id");
        assertThat(result.getName()).isEqualTo("name");
        assertThat(result.getPassword()).isEqualTo("pass");
    }


}
