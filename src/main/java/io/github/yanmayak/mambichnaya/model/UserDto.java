package io.github.yanmayak.mambichnaya.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Schema(description = "Карточка пользователя")
public class UserDto {
    @Schema(description = "id пользователя")
    private Long id;

    @Schema(description = "Имя пользователя")
    private String firstName;

    @Schema(description = "Фамилия пользователя")
    private String lastName;

    @Schema(description = "Никнейм пользователя")
    private String username;

    @Schema(description = "Биография пользователя")
    private String bio;

    @Schema(description = "Фото пользователя (base64)")
    private String photo;

    @Schema(description = "Комментарий пользователя")
    private String message;

    @Schema(description = "Чекбокс настройки проверки имени пользователя")
    private boolean usernameCheck;

    @Schema(description = "Чекбокс настройки проверки пользователя в БД сторонних ботов")
    private boolean dbCheck;

    @Schema(description = "Чекбокс настройки проверки аватарки пользователя")
    private boolean photoCheck;

    @Schema(description = "Чекбокс настройки проверки раздела \"о себе\" пользователя")
    private boolean bioCheck;

    @Schema(description = "Чекбокс настройки проверки содержания сообщения")
    private boolean messageCheck;
}
