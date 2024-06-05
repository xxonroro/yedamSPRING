package com.yedam.app.upload.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

// 부트 3버전
@Configuration
public class MultipartConfig {

	@Bean // 동작을 담당하는 빈
	MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	@Bean // 설정을 담당하는 빈
	MultipartConfigElement multipartConfigElement( ) {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setFileSizeThreshold(DataSize.ofMegabytes(0));
		factory.setLocation("C:/Temp");
		factory.setMaxFileSize(null);
		factory.setMaxRequestSize(null);
		
		
		return factory.createMultipartConfig();
	}
	
	
}
