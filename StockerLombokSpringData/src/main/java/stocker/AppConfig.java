 package stocker;

 import javax.sql.DataSource;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.ComponentScan;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.context.annotation.PropertySource;
 import org.springframework.core.env.Environment;
 import org.springframework.jdbc.datasource.DriverManagerDataSource;

 @Configuration
 @ComponentScan(basePackages="stocker")
 @PropertySource("classpath:database.properties")
 public class AppConfig {

 	@Autowired
 	Environment environment;

 	@Bean
 	DataSource dataSource() {
 
 		DriverManagerDataSource dmds = new DriverManagerDataSource();
 		dmds.setUrl(environment.getProperty("url"));
 		dmds.setDriverClassName(environment.getProperty("driverClassName"));
 		dmds.setUsername(environment.getProperty("dbname"));
 		dmds.setPassword(environment.getProperty("dbpassword"));
 		return dmds;
 	}

 }
