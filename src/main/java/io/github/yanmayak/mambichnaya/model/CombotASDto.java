package io.github.yanmayak.mambichnaya.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Карточка ответа бота Combot Anti-Spam")
public class CombotASDto {
    @Schema(description = "ok response")
    private Boolean ok;

    @Schema(description = "Причины бана")
    private List<Object> reason;
}
