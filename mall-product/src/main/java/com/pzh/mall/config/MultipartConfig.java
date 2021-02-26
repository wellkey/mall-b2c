package com.pzh.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @Description TODO 文件上传配置
 * @Author panzhh
 * @Date 2021/2/26 11:25
 * @Version 1.0
 */
@Configuration
public class MultipartConfig {

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
}