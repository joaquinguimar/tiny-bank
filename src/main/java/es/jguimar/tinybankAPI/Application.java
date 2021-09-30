package es.jguimar.tinybankAPI;

import es.jguimar.tinybankAPI.adapter.mongo.UserMongoRepository;
import es.jguimar.tinybankAPI.adapter.mongo.UserRepositoryImpl;
import es.jguimar.tinybankAPI.adapter.mongo.WalletMongoRepository;
import es.jguimar.tinybankAPI.adapter.mongo.WalletRepositoryImpl;
import es.jguimar.tinybankAPI.application.port.inbound.UserReadRepository;
import es.jguimar.tinybankAPI.application.port.inbound.WalletReadRepository;
import es.jguimar.tinybankAPI.application.port.outbound.UserWriteRepository;
import es.jguimar.tinybankAPI.application.port.outbound.WalletWriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication()
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public UserReadRepository userBoxReadRepository() {
		return new UserRepositoryImpl(userMongoRepository);
	}

	@Bean
	public UserWriteRepository userWriteRepository() {
		return new UserRepositoryImpl(userMongoRepository);
	}

	@Bean
	public WalletReadRepository walletReadRepository() {
		return new WalletRepositoryImpl(walletMongoRepository);
	}

	@Bean
	public WalletWriteRepository walletWriteRepository() {
		return new WalletRepositoryImpl(walletMongoRepository);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	UserMongoRepository userMongoRepository;

	@Autowired
	WalletMongoRepository walletMongoRepository;

}
