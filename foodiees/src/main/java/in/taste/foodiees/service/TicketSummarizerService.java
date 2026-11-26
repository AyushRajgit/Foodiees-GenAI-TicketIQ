package in.taste.foodiees.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class TicketSummarizerService {

    private ChatClient chatClient;

    public TicketSummarizerService(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    public String summarize(String email, String issue) {
        String summarized_Output = chatClient
                .prompt()
                .user("Summarize the given text into 2 lines only if it related to food complaint\n\n" + issue)
                .call()
                .content();

        return summarized_Output;
    }
}
