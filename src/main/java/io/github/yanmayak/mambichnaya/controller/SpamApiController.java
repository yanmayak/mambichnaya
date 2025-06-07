package io.github.yanmayak.mambichnaya.controller;

import io.github.yanmayak.mambichnaya.model.AIRequestDto;
import io.github.yanmayak.mambichnaya.model.AIResponseDto;
import io.github.yanmayak.mambichnaya.model.CheckDto;
import io.github.yanmayak.mambichnaya.model.UserDto;
import io.github.yanmayak.mambichnaya.service.DeepSeekService;
import io.github.yanmayak.mambichnaya.service.PromtService;
import io.github.yanmayak.mambichnaya.service.SpamApiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/checks")
@AllArgsConstructor
public class SpamApiController {
    private final SpamApiService spamApiService;
    private final DeepSeekService deepSeekService;
    private final PromtService promtService;

    @PostMapping("/user/bot")
    public CheckDto checkInBots(UserDto userDto) {
        return spamApiService.checkInBots(userDto);
    }

    @PostMapping("/prefs")
    public String setPromtPrefs(UserDto userDto) {
        return promtService.promt(userDto);
    }

    @PostMapping("/user/ai")
    public AIResponseDto checkInAI(UserDto userDto) {
        return deepSeekService.checkUserByAi(
                new AIRequestDto(userDto.getUsername(),
                        userDto.getBio(),
                        userDto.getMessage()));
    }

}
