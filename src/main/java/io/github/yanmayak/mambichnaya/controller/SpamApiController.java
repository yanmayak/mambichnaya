package io.github.yanmayak.mambichnaya.controller;

import io.github.yanmayak.mambichnaya.model.*;
import io.github.yanmayak.mambichnaya.service.DeepSeekService;
import io.github.yanmayak.mambichnaya.service.PromtService;
import io.github.yanmayak.mambichnaya.service.SpamApiService;
import io.github.yanmayak.mambichnaya.service.impl.CheckBanned;
import io.github.yanmayak.mambichnaya.service.impl.PromtServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/checks")
@AllArgsConstructor
public class SpamApiController {
    private final SpamApiService spamApiService;
    private final DeepSeekService deepSeekService;
    private final PromtService promtService;
    private final CheckBanned checkBanned;

    @PostMapping("/user/bot")
    public CheckDto checkInBots(UserDto userDto) {
        return spamApiService.checkInBots(userDto);
    }

    @PostMapping("/prefs")
    public String setPromtPrefs(UserDto userDto) {
        return promtService.promt(userDto);
    }

    @PostMapping("/user")
    public AIResponseDto check(UserDto userDto) {
        if (checkBanned.checkBanned(userDto.getId())) {
            return this.banned(userDto);
        }

        if (userDto.isDbCheck()) {
            CheckDto checkDto = spamApiService.checkInBots(userDto);
            if (!checkDto.getIsOk()) {
                return this.banned(userDto);
            }
        }

        if (
                userDto.getMessage() != null &&
                        !userDto.getMessage().isEmpty() &&
                        !userDto.getMessage().equals(" ")
                        || !PromtServiceImpl.INTRO.concat(PromtServiceImpl.FORMATTING).equals(promtService.promt(userDto))
        ) {
            return deepSeekService.checkUserByAi(
                    userDto.getId(),
                    new AIRequestDto(
                            "deepseek-chat",
                            List.of(
                                    new AiMessagesDto("system", promtService.promt(userDto)),
                                    new AiMessagesDto("user", promtService.jsonPromt(userDto))
                            ),
                            false
                    )
            );
        }

        if (userDto.isPhotoCheck()) {
            //тут чек нейронкой
        }

        return ok(userDto);
    }

    private AIResponseDto banned(UserDto userDto) {
        return this.resp(userDto, true);
    }

    private AIResponseDto ok(UserDto userDto) {
        return this.resp(userDto, false);
    }

    private AIResponseDto resp(UserDto userDto, boolean banned) {
        return new AIResponseDto(
                !banned,
                userDto.getMessage(),
                null,
                LocalDateTime.now()
        );
    }
}
