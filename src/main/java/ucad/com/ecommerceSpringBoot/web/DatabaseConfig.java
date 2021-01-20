package ucad.com.ecommerceSpringBoot.web;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DatabaseConfig {

    @Value("${postgres://qkzwphjxunpmep:7505750a7b92e945e9b6c212f58767aa1d7b71d1159190ebf41845a66d362d60@ec2-54-75-248-49.eu-west-1.compute.amazonaws.com:5432/d4ndcpa8gm9s41}")
    private String dbUrl;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        return new HikariDataSource(config);
    }
}
