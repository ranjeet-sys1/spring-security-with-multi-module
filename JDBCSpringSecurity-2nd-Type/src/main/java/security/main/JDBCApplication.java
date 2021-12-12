package security.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"security.config","security.controller","security.main"})
public class JDBCApplication {
    public static void main(String[] args) {
        SpringApplication.run(JDBCApplication.class);
    }
}
