package io.github.yanmayak.mambichnaya.service.impl;

import io.github.yanmayak.mambichnaya.client.LolsBotClient;
import io.github.yanmayak.mambichnaya.model.LolsBotDto;
import io.github.yanmayak.mambichnaya.service.LolsBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LolsBotServiceImpl implements LolsBotService {
    private final LolsBotClient lolsBotClient;

    @Override
    public Boolean LolsCheck(Long userId,
                             Boolean quick) {
        LolsBotDto LolsResponse = lolsBotClient.lolsCheck(userId.intValue(), quick);
        return !LolsResponse.isOk();
    }
}
