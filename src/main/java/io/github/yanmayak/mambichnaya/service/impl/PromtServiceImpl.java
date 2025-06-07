package io.github.yanmayak.mambichnaya.service.impl;

import io.github.yanmayak.mambichnaya.model.AIRequestDto;
import io.github.yanmayak.mambichnaya.model.AIResponseDto;
import io.github.yanmayak.mambichnaya.model.UserDto;
import io.github.yanmayak.mambichnaya.service.PromtService;
import org.springframework.stereotype.Service;

@Service
public class PromtServiceImpl implements PromtService {
    private StringBuffer buffer;
    private final String INTRO = """
            Проведи комплексную проверку пользователя Telegram и 
            его сообщения по следующим критериям:
            """;
    private final String CHECK_USERNAME = """
            1. Анализ никнейма (username):
            	•	Проверь, содержит ли никнейм явные признаки рекламы товаров 
            	или услуг (например, слова типа "купить", "продам", "заказ", "услуги",
            	 "магазин", "скидки", "обмен" и т. п.).
            	•	Проверь, нет ли в никнейме подозрительных комбинаций символов,
            	 указывающих на скрытую рекламу (например, "best_shop_24",
            	  "crypto_exchange", "earn_money_here", в том числе на русском языке).
            """;
    private final String CHECK_BIO = """
            . Анализ раздела "О себе" (bio):
            	•	Проверь текст на наличие рекламы товаров или услуг 
            	(например, предложения купить что-либо, реклама каналов,
            	 коммерческих услуг).
            	•	Просканируй текст на наличие ссылок. 
            	Если ссылки есть, проанализируй их:
            	◦	Ведёт ли домен на сторонний ресурс (не Telegram/Telegra.ph)?
            	◦	Содержит ли ссылка упоминание запрещённых тем 
            	(наркотики, оружие, мошенничество, взлом, порнография, экстремизм и т. п.)?
            	◦	Ведёт ли ссылка на канал/чат с нежелательным контентом 
            	(призывы к насилию, разжигание ненависти, обход блокировок)?
            """;
    private final String CHECK_MESSAGE = """
            3. Анализ сообщения пользователя (message):
            	•	Проверь текст на признаки рекламы (предложения купить/продать, реклама 
            	услуг, спам-рассылка).
            	•	Проверь, нет ли в сообщении ссылок. Если ссылки есть, проанализируй их:
            	◦	Ведёт ли домен на сторонний ресурс (не Telegram/Telegra.ph)?
            	◦	Содержит ли ссылка упоминание запрещённых тем 
            	(наркотики, оружие, мошенничество, взлом, порнография, экстремизм и т. п.)?
            	◦	Ведёт ли ссылка на канал/чат с нежелательным контентом 
            	(призывы к насилию, разжигание ненависти, обход блокировок)?
            	•	Проверь, не похоже ли сообщение на нейрокомментинг 
            	(бессмысленный или шаблонный текст, который мог быть сгенерирован 
            	ИИ, например: "Отличный канал! Советую всем подписаться!" или 
            	"смотри инфо у меня в профиле" без конкретики).
            	•	Оцени, нет ли в сообщении призывов к нарушению закона, 
            	насилию, распространению запрещённого контента.
            """;
    private final String FORMATTING = """
            Формат ввода JSON:
            {
              "username": "string",
              "bio": "string",
              "message": "string",
            }
            Формат вывода:
            Предоставь ответ в виде json:
            {
              "isOk": true,
              "message": "string",
              "reason": "string"
            }
            , где:
            isOk = true, если пользователь прошел все проверки по заданным параметрам. Поля message и reason в таком случае не возвращай.\s
            Если пользователь не прошел хотя бы одну проверку, то необходимо передать isOk = false, сообщение пользователя в message и причину в reason, из-за которой пользователь не прошел проверку.
            """;

    @Override
    public String promt(UserDto userDto) {
        if (!buffer.isEmpty()) {
            buffer.delete(0, buffer.length());
        }
        buffer.append(INTRO);
        if (userDto.isUsernameCheck()) {
            buffer.append(CHECK_USERNAME);
        }
        if (userDto.isBioCheck()) {
            buffer.append(CHECK_BIO);
        }
        if (userDto.isMessageCheck()) {
            buffer.append(CHECK_MESSAGE);
        }
        buffer.append(FORMATTING);
        return buffer.toString();
    }

    @Override
    public AIRequestDto jsonPromt(UserDto userDto) {
        return new AIRequestDto(userDto.getUsername(), userDto.getBio(), userDto.getMessage());
    }
}
