package io.github.yanmayak.mambichnaya.controller;

import io.github.yanmayak.mambichnaya.entity.User;
import io.github.yanmayak.mambichnaya.model.*;
import io.github.yanmayak.mambichnaya.repository.BannedUsersRepository;
import io.github.yanmayak.mambichnaya.service.DeepSeekService;
import io.github.yanmayak.mambichnaya.service.PromtService;
import io.github.yanmayak.mambichnaya.service.SpamApiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/checks")
@AllArgsConstructor
public class SpamApiController {
    private final SpamApiService spamApiService;
    private final DeepSeekService deepSeekService;
    private final PromtService promtService;
    private final BannedUsersRepository bannedUsersRepository;


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
        AIResponseDto responseDto = deepSeekService.checkUserByAi(
                new AIRequestDto(
                        "deepseek-chat",
                        List.of(
                                new AiMessagesDto("user", userDto.toString()),
                                new AiMessagesDto("system", promtService.promt(userDto))
                        ),
                        false
                )
        );
        if (!responseDto.isOk()) {
            bannedUsersRepository.save(
                    new User(
                            userDto.getId(),
                            responseDto.getMessage(),
                            responseDto.getReason(),
                            responseDto.getDateBanned()
                    )
            );
        }

        return responseDto;
    }
}
