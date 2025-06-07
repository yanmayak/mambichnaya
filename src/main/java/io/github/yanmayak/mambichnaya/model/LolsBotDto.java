package io.github.yanmayak.mambichnaya.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Карточка ответа бота LolsBot")
public class LolsBotDto {
    @Schema(description = "ok response")
    private boolean ok;

    @Schema(description = "id пользователя")
    private Long id;

    @Schema(description = "Карточка ответа бота LolsBot")
    private Boolean isOk; //todo: response is in "is banned" state, need to inverse

}
