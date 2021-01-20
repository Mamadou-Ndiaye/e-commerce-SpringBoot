package ucad.com.ecommerceSpringBoot.web;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DatabaseConfig {
  // Pour dreployer sur heroku cela veut dire qu on a pas besoin ca a part ca

    @Value("${postgres://hklkutbzfjusli:81b94d5a5554a6e5c22e242e0598a6c72cb681f1f50ebc1a373487fbccdae81f@ec2-54-144-45-5.compute-1.amazonaws.com:5432/d7pfib19bhaht4}")
    private String dbUrl;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        return new HikariDataSource(config);
    }
}
