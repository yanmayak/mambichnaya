package io.github.yanmayak.mambichnaya.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AIRequestDto {
    @Schema(description = "Никнейм пользователя")
    private String username;

    @Schema(description = "Биография пользователя")
    private String bio;

    @Schema(description = "Комментарий пользователя")
    private String message;
}
