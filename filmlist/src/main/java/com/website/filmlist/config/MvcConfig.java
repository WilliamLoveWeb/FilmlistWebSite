package com.website.filmlist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class configure the MVC model of our project
 * 
 * @author williammeilland
 *
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	/**
	 * This procedure associate a view Name to a view Controller 
	 * @param registry allow this association
	 * 
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home.html");
		registry.addViewController("/search").setViewName("search.html");
	}

}
