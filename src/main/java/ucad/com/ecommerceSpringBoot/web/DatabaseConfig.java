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

    @Value("${postgres://agmsrryjuclbnz:638d94fbb1decae58e200b39963ecf90e34d620c2c812054cc2a071f7093106c@ec2-54-84-98-18.compute-1.amazonaws.com:5432/d2rmnkgn8pprg}")
    private String dbUrl;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        return new HikariDataSource(config);
    }
}
