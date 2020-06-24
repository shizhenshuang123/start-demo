package org.example.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyLogProperties.class)
@ConditionalOnBean(MyLogConfiguration.class)
public class MyLogAutoConfiguration {
    @Bean
    public MyLogAspect myLogAspect(MyLogProperties myLogProperties) {
        return new MyLogAspect(myLogProperties);
    }

}
