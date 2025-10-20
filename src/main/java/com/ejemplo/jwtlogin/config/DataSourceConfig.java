package com.ejemplo.jwtlogin.config;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableJpaRepositories("com.ejemplo.jwtlogin")
@EntityScan("com.ejemplo.jwtlogin")
@EnableScheduling
public class DataSourceConfig {

	// =================== BD LOLFAR (Principal) ===================
	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSourceProperties lolfarDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "lolfarDataSource")
	public DataSource lolfarDataSource() {
		return lolfarDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean(name = "lolfarJdbcTemplate")
	public JdbcTemplate lolfarJdbcTemplate(@Qualifier("lolfarDataSource") DataSource ds) {
		return new JdbcTemplate(ds);
	}

	// =================== BD SIGOLDB (Secundaria) ===================
	@Bean
	@ConfigurationProperties("spring.second-datasource")
	public DataSourceProperties sigoldbDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "sigoldbDataSource")
	public DataSource sigoldbDataSource() {
		return sigoldbDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean(name = "sigoldbJdbcTemplate")
	public JdbcTemplate sigoldbJdbcTemplate(@Qualifier("sigoldbDataSource") DataSource ds) {
		return new JdbcTemplate(ds);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setFieldMatchingEnabled(true);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
}
