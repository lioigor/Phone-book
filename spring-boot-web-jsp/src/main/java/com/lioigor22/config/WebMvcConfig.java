package com.lioigor22.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/* Configuration for localization of Spring boot app
 * 
 * Place your resource files in src/main/resources/lang/
 * and name them 
 *   messages.properties (default fallback)
 *   messages_de.properties
 *   messages_en.properties
 *   
 * messages.properties example content:
 * welcome=Welcome
 * 
 */

@Configuration
@ComponentScan
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:lang/messages");
		messageSource.setCacheSeconds(10); // reload messages every 10 seconds
		return messageSource;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
