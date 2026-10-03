package epic3.epic3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"epic3.epic3", "com.epic3"})
@EntityScan("com.epic3.model")
@EnableJpaRepositories("com.epic3.repository")
public class Epic3Application {

    public static void main(String[] args) {
        SpringApplication.run(Epic3Application.class, args);
    }
}