package io.github.yanmayak.mambichnaya.controller;

import io.github.yanmayak.mambichnaya.model.CheckDto;
import io.github.yanmayak.mambichnaya.model.UserDto;
import io.github.yanmayak.mambichnaya.service.SpamApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/checks")
@RequiredArgsConstructor
public class SpamApiController {
    private final SpamApiService spamApiService;

    @PostMapping("/user")
    public CheckDto check(UserDto userDto) {
        return spamApiService.check(userDto);
    }

    @PostMapping("/batch")
    public List<CheckDto> checkBatch(List<UserDto> userDtos) {
        return spamApiService.checkBatch(userDtos);
    }
}
