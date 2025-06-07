package io.github.yanmayak.mambichnaya.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "deepseek.api")
@Getter
@Setter
public class DeepSeekConfig {
    private String url;
    private String key;
}
