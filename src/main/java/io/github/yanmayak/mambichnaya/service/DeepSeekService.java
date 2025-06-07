package io.github.yanmayak.mambichnaya.service;

import io.github.yanmayak.mambichnaya.model.AIRequestDto;
import io.github.yanmayak.mambichnaya.model.AIResponseDto;

public interface DeepSeekService {
    AIResponseDto checkUserByAi(AIRequestDto aiRequestDto);
}
