package tr.com.iyzico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@Import(DatabaseConfig.class)
public class IyzicoticketApplication {

	public static void main(String[] args) {
		SpringApplication.run(IyzicoticketApplication.class, args);
	}


}
