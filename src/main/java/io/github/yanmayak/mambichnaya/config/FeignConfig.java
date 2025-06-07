package io.github.yanmayak.mambichnaya.config;

import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FeignConfig {
    private final DeepSeekConfig deepSeekConfig;

    @Bean
    public RequestInterceptor apiKeyInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer " + deepSeekConfig.getKey());
            requestTemplate.header("Content-Type", "application/json");
        };
    }
}
