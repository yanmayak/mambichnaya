package io.github.yanmayak.mambichnaya.service.impl;

import io.github.yanmayak.mambichnaya.model.CheckDto;
import io.github.yanmayak.mambichnaya.model.UserDto;
import io.github.yanmayak.mambichnaya.service.CombotASService;
import io.github.yanmayak.mambichnaya.service.LolsBotService;
import io.github.yanmayak.mambichnaya.service.SpamApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpamApiServiceImpl implements SpamApiService {
    private final CombotASService combotASService;
    private final LolsBotService lolsBotService;

    @Override
    public CheckDto check(UserDto userDto) {
        Boolean isOk = lolsBotService.LolsCheck(userDto.getId(), false) &&
                combotASService.CombotASCheck(userDto.getId());
        return new CheckDto(userDto.getId(), isOk);
    }
}
