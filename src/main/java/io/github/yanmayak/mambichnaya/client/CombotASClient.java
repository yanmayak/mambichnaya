package io.github.yanmayak.mambichnaya.client;

import io.github.yanmayak.mambichnaya.model.CombotASDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "combotASClient", url = "https://api.cas.chat")
public interface CombotASClient {
    @GetMapping("/check")
    CombotASDto combotASCheck(@RequestParam Integer userId);
}
