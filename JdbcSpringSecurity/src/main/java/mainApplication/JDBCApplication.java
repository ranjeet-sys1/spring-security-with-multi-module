package mainApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages={"config","controller","mainApplication"})
public class JDBCApplication {
    public static void main(String[] args) {
        SpringApplication.run(JDBCApplication.class);
    }
}
