package io.github.yanmayak.mambichnaya.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AiMessagesDto {
    private String role;
    private String content;
}
