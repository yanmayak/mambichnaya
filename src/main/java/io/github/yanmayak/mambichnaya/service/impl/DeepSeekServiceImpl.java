package io.github.yanmayak.mambichnaya.service.impl;

import io.github.yanmayak.mambichnaya.controller.StatelessChatService;
import io.github.yanmayak.mambichnaya.model.AIRequestDto;
import io.github.yanmayak.mambichnaya.model.AIResponseDto;
import io.github.yanmayak.mambichnaya.service.DeepSeekService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DeepSeekServiceImpl implements DeepSeekService {
    private final StatelessChatService chatService;

    @SneakyThrows
    @Override
    public AIResponseDto checkUserByAi(Long userId, AIRequestDto aiRequestDto) {
        return new AIResponseDto(
                chatService.generateResponse(
                        aiRequestDto.getMessages().get(0).getContent(),
                        aiRequestDto.getMessages().get(1).getContent()
                ).contains("true"),
                aiRequestDto.getMessages().get(1).getContent(),
                "",
                LocalDateTime.now()
        );
    }
}
