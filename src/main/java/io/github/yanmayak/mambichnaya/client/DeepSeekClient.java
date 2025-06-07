package io.github.yanmayak.mambichnaya.client;

import io.github.yanmayak.mambichnaya.config.FeignConfig;
import io.github.yanmayak.mambichnaya.entity.User;
import io.github.yanmayak.mambichnaya.model.AIRequestDto;
import io.github.yanmayak.mambichnaya.model.AIResponseDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "deepSeekApiClient",
        url = "${deepseek.api.url}",
        configuration = FeignConfig.class
)
public interface DeepSeekClient {
    @PostMapping("/v1/check")
    AIResponseDto checkUser(@RequestBody AIRequestDto request);
}
