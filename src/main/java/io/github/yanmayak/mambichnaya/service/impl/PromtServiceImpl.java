package io.github.yanmayak.mambichnaya.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.yanmayak.mambichnaya.model.PromtDto;
import io.github.yanmayak.mambichnaya.model.UserDto;
import io.github.yanmayak.mambichnaya.service.PromtService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class PromtServiceImpl implements PromtService {
    public static final String INTRO = """
            ОБЯЗАТЕЛЬНО СООТВЕТСТВУЙ ФОРМАТУ ВВОДА И ВЫВОДА!
            ОТВЕТ НЕ ДОЛЖЕН СОДЕРЖАТЬ НИ КАКОГО ШАБЛОНА КРОМЕ УКАЗАННОГО В ФОРМАТЕ ОТВЕТА (НУЖНО НА ОСНОВАНИИ НИЖЕСТОЯЩИХ ПРАВИЛ НЕОБХОДИМО ОПРЕДЕЛИТЬ isOk=true или isOk=false)!
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
    public static final String FORMATTING = """
            Формат ввода JSON:
            {
              "username": "string", //юзернейм
              "bio": "string", //о себе
              "message": "string", //сообщение юзера
            }
            Формат вывода:
            Предоставь ответ в виде json:
            {
              "isOk": true
            }
            , где:
            isOk = true, если пользователь не спамер/бот и успешно прошел все вышеперечисленные проверки.
            """;

    @Override
    public String promt(UserDto userDto) {
        StringBuilder buffer = new StringBuilder();
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

    @SneakyThrows
    @Override
    public String jsonPromt(UserDto userDto) {
        return new ObjectMapper().writeValueAsString(new PromtDto(userDto.getUsername(), userDto.getBio(), userDto.getMessage()));
    }
}
