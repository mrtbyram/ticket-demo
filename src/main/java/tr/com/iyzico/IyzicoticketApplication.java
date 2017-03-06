package tr.com.iyzico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@SpringBootApplication
@EnableJpaRepositories
public class IyzicoticketApplication {

	public static void main(String[] args) {
		SpringApplication.run(IyzicoticketApplication.class, args);
	}

	@Bean
	@Profile("test")
	public DataSource testDataSource(){
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.HSQL)
				.addScript("test-db-ddl.sql")
				.build();
	}
}
