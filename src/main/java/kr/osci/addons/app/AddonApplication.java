package kr.osci.addons.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "kr.osci.addons.app.domain.board")
public class AddonApplication {

    public static void main(String[] args) {
        new SpringApplication(AddonApplication.class).run(args);
    }
}
