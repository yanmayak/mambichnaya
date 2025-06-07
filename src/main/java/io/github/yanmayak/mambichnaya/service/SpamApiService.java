package io.github.yanmayak.mambichnaya.service;

import io.github.yanmayak.mambichnaya.model.AIResponseDto;
import io.github.yanmayak.mambichnaya.model.CheckDto;
import io.github.yanmayak.mambichnaya.model.UserDto;


public interface SpamApiService {
CheckDto checkInBots(UserDto userDto);
}
