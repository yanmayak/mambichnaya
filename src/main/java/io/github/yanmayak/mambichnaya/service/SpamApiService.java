package io.github.yanmayak.mambichnaya.service;

import io.github.yanmayak.mambichnaya.model.CheckDto;
import io.github.yanmayak.mambichnaya.model.UserDto;

import java.util.List;

public interface SpamApiService {
CheckDto check(UserDto userDto);
List<CheckDto> checkBatch(List<UserDto> userDtos);
}
