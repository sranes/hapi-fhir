package ca.uhn.fhir.jpa.config;

import java.util.Properties;

import ca.uhn.fhir.jpa.model.dialect.HapiFhirH2Dialect;
import org.hibernate.search.backend.elasticsearch.index.layout.IndexLayoutStrategy;
import org.hibernate.search.backend.lucene.cfg.LuceneBackendSettings;
import org.hibernate.search.engine.cfg.BackendSettings;
import org.hibernate.search.mapper.orm.cfg.HibernateOrmMapperSettings;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ca.uhn.fhir.jpa.dao.IFulltextSearchSvc;

@Configuration
@EnableTransactionManagement()
public class TestR4WithLuceneDisabledConfig extends TestR4Config {

	/**
	 * Disable fulltext searching
	 */
	@Override
	public IFulltextSearchSvc searchDaoR4() {
		return null;
	}

	@Override
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(ConfigurableListableBeanFactory theConfigurableListableBeanFactory) {
		LocalContainerEntityManagerFactoryBean retVal = super.entityManagerFactory(theConfigurableListableBeanFactory);
		retVal.setDataSource(dataSource());
		retVal.setJpaProperties(jpaProperties());
		return retVal;
	}

	@Override
	public Properties jpaProperties() {
		Properties extraProperties = new Properties();
		extraProperties.put("hibernate.format_sql", "false");
		extraProperties.put("hibernate.show_sql", "false");
		extraProperties.put("hibernate.hbm2ddl.auto", "update");
		extraProperties.put("hibernate.dialect", HapiFhirH2Dialect.class.getName());
		extraProperties.put(HibernateOrmMapperSettings.ENABLED, "false");
		return extraProperties;
	}

}
