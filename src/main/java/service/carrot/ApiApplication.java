package service.carrot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.delivery.request"})
//@EntityScan("service.carrot.domain")
//@EnableJpaRepositories("service.carrot.repository")
/**
 * 아직 db설정 단계는 아님으로 건너뛴다
 *
 * Description:
 *
 * Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
 *
 * Reason: Failed to determine a suitable driver class
 */
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
