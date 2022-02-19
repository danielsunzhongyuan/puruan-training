package org.github.zsun.java.puruantraining.filter;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigMyGlobalFilter {
    @Bean
    public GlobalFilter configFilter() {
        return new MyGlobalFilter();
    }
}
