package io.github.yanmayak.mambichnaya.service.impl;

import io.github.yanmayak.mambichnaya.client.DeepSeekClient;
import io.github.yanmayak.mambichnaya.entity.User;
import io.github.yanmayak.mambichnaya.model.AIRequestDto;
import io.github.yanmayak.mambichnaya.model.AIResponseDto;
import io.github.yanmayak.mambichnaya.model.UserDto;
import io.github.yanmayak.mambichnaya.repository.BannedUsersRepository;
import io.github.yanmayak.mambichnaya.service.DeepSeekService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DeepSeekServiceImpl implements DeepSeekService {
    private final DeepSeekClient deepSeekClient;
    private final BannedUsersRepository bannedUsersRepository;

    @Override
    public AIResponseDto checkUserByAi(AIRequestDto aiRequestDto) {
        AIResponseDto aiResponseDto = deepSeekClient.checkUser(aiRequestDto);
        aiResponseDto.setDateBanned(LocalDateTime.now());
        return aiResponseDto;
    }
}
