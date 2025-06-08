package io.github.yanmayak.mambichnaya.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
public class StatelessChatService {
    private final ChatClient chatClient;

    public StatelessChatService(ChatModel model) {
        chatClient = ChatClient.builder(model)
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
    }

    public String generateResponse(String system, String user) {
        Prompt prompt = new Prompt(
                new SystemMessage(system),
                new UserMessage(user)
        );

        return chatClient.prompt(prompt)
                .call().chatResponse().getResult().getOutput().getText();
    }
}
