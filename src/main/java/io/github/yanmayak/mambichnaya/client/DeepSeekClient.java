package io.github.yanmayak.mambichnaya.client;

import io.github.yanmayak.mambichnaya.model.AIRequestDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "deepSeekApiClient",
        url = "${deepseek.api.url}"
)
public interface DeepSeekClient {
    @PostMapping(value = "/chat/completions", consumes = "application/json")
    String checkUser(
            @RequestHeader(name = "Authorization") String token,
            @RequestBody AIRequestDto request
    );
}
