package com.navercorp.example.quartztest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * DispatcherServlet이 읽어들일 설정과 Bean을 정의하는 클래스
 *
 * @author 국윤창
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.navercorp.example.quartztest"})
public class WebAppConfig extends WebMvcConfigurerAdapter {
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
