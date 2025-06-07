package io.github.yanmayak.mambichnaya.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Карточка проверки пользователя")
public class CheckDto {
    @Schema(description = "id пользователя")
    private Long userId;

    @Schema(description = "Результат проверки пользователя")
    private Boolean isOk;
}
