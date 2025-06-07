package io.github.yanmayak.mambichnaya.service;

import io.github.yanmayak.mambichnaya.model.AIRequestDto;
import io.github.yanmayak.mambichnaya.model.PromtDto;
import io.github.yanmayak.mambichnaya.model.UserDto;

public interface PromtService {
    String promt(UserDto userDto);
    PromtDto jsonPromt(UserDto userDto);
}
