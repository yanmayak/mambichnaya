package io.github.yanmayak.mambichnaya.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Карточка пользователя")
public class UserDto {
    @Schema(description = "id пользователя")
    private Integer id;

    @Schema(description = "Имя пользователя")
    private String firstName;

    @Schema(description = "Фамилия пользователя")
    private String lastName;

    @Schema(description = "Никнейм пользователя")
    private String username;

    @Schema(description = "Фото пользователя (base64)")
    private String photo;
}
