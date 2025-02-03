package springbootawsbook.springawsbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringawsbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringawsbookApplication.class, args);
	}

}
