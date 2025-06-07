package io.github.yanmayak.mambichnaya.service;

import io.github.yanmayak.mambichnaya.model.CheckDto;
import io.github.yanmayak.mambichnaya.model.UserDto;

public interface SpamApiService {
CheckDto check(UserDto userDto);

}
