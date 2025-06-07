package io.github.yanmayak.mambichnaya.client;

import io.github.yanmayak.mambichnaya.model.LolsBotDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "lolsBotClient", url = "https://api.lols.bot/")
public interface LolsBotClient {
    @GetMapping("/account")
    LolsBotDto lolsCheck(@RequestParam("id") Integer userId,
                         @RequestParam("quick") Boolean quick);
}
