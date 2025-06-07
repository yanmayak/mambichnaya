package io.github.yanmayak.mambichnaya.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AIRequestDto {
    private String model;
    private List<AiMessagesDto> messages;
    private boolean stream;
}
