package com.example.kmarket.util;

import jakarta.servlet.MultipartConfigElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
public class MultipartConfig {
    @Value("${file.multipart.maxUploadSize:10485760}")
    private long maxUploadSize;

    @Value("${file.multipart.maxUploadSizePerFile:10485760}")
    private long maxUploadSizePerFile;

    // 스프링부트 3.0 부터는 multipart 수행을 담당하는 MultipartResolver가 
    // StandardServletMultipartResolver 로 기본으로 변경됨 
    // 따라서 아래와 같이 Bean등록을 수행하여 multipart/form 요청에 대한 처리 모듈 등록
    // https://kindloveit.tistory.com/112
    @Bean
    public MultipartResolver multipartResolver() {
        StandardServletMultipartResolver multipartResolver
                = new StandardServletMultipartResolver();
        return multipartResolver;
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxRequestSize(DataSize.ofBytes(maxUploadSize));
        factory.setMaxFileSize(DataSize.ofBytes(maxUploadSizePerFile));

        return factory.createMultipartConfig();
    }
}
