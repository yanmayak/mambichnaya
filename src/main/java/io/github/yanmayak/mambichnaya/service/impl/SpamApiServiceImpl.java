package io.github.yanmayak.mambichnaya.service.impl;

import io.github.yanmayak.mambichnaya.model.CheckDto;
import io.github.yanmayak.mambichnaya.model.UserDto;
import io.github.yanmayak.mambichnaya.service.CombotASService;
import io.github.yanmayak.mambichnaya.service.LolsBotService;
import io.github.yanmayak.mambichnaya.service.SpamApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<CheckDto> checkBatch(List<UserDto> userDtos) {
        List<CheckDto> checkDtos = new ArrayList<>();
        for (UserDto userDto : userDtos) {
            checkDtos.add(check(userDto));
        }
        return checkDtos;
    }
}
