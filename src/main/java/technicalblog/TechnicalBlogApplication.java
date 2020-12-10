package technicalblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// below annotations are Redundant declaration: @SpringBootApplication already applies
// @ComponentScan
// @EnableAutoConfiguration
public class TechnicalBlogApplication {

    public static void main(String [] args) {

        SpringApplication.run(TechnicalBlogApplication.class, args);

    }
}
