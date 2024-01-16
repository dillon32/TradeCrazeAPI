package com.dheyck.tradecraze;

import javax.sql.DataSource;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@Log
public class TradecrazeApplication {

	private final DataSource dataSource;

	public TradecrazeApplication(final DataSource dataSource) { this.dataSource = dataSource; }
	public static void main(String[] args) {
		SpringApplication.run(TradecrazeApplication.class, args);
	}

	public void run(final String... args) {
		log.info("atasource..." + dataSource.toString());
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("select 1");
	}
}
