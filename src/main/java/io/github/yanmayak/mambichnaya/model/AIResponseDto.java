package io.github.yanmayak.mambichnaya.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Карточка ответа ИИ-агента")
public class AIResponseDto {
    @Schema(description = "Наличие бана у пользователя")
    private boolean isOk;

    @Schema(description = "Сообщение пользователя")
    private String message;

    @Schema(description = "Причина бана пользователя")
    private String reason;

    @Schema(description = "Дата бана")
    private LocalDateTime dateBanned;
}
