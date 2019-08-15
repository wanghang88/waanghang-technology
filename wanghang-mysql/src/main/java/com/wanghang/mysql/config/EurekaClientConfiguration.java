package com.wanghang.mysql.config;


import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 * 这个配置在IDea中加上   Configuration的
 * VM opition -Dspring.profiles.active=local 这个配置，本地启的就不会注册到注册中心上了
 */
@Profile("!local")
@Configuration
@EnableDiscoveryClient
public class EurekaClientConfiguration {
}
