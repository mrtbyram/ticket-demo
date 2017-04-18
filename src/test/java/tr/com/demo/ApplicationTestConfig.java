package tr.com.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by muratbayram on 18/04/2017.
 */
@Configuration
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@ComponentScan("tr.com.demo.*")
@EnableJpaRepositories
public class ApplicationTestConfig {
}
