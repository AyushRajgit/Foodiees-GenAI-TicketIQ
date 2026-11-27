package in.taste.foodiees.service;

import in.taste.foodiees.dto.TicketResponseDTO;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class TicketSummarizerService {

    private final String companySpecificPrompt = """
        You are an AI-powered customer support ticket analyzer
        for a food-related company.

        Analyze the customer complaint and generate the following:

        1. Summary:
           Summarize the complaint in exactly two sentences.

        2. Category:
           Select exactly one:
           DELIVERY, PAYMENT, WRONG_ITEM, FOOD_QUALITY,
           REFUND, ORDER_CANCELLATION, OTHER.

        3. Priority:
           Select exactly one:
           LOW, MEDIUM, HIGH, CRITICAL, NOT_APPLICABLE.

        4. Sentiment:
           Select exactly one:
           POSITIVE, NEUTRAL, NEGATIVE, NOT_APPLICABLE.

        5. Suggested Action:
           Recommend an appropriate action for the support employee.

        IMPORTANT RULES:

        - Only analyze complaints related to food, food delivery,
          food ordering, payments, refunds, and related services.
        - If unrelated to food strictly deny any action as we only handle food related query, set category to OTHER and both priority
          and sentiment to NOT_APPLICABLE.
        - For spoiled, contaminated, or potentially unsafe food,
          set priority to CRITICAL and require human review.
        - Never invent information that is not present in the complaint.
        - Do not recommend automatically closing food safety complaints.
        """;

    private ChatClient chatClient;
    private TicketSaverService ticketSaverService;

    public TicketSummarizerService(ChatClient.Builder chatClient, TicketSaverService ticketSaverService) {
        this.chatClient = chatClient.build();
        this.ticketSaverService = ticketSaverService;
    }

    public TicketResponseDTO summarize(String email, String issue) {
         TicketResponseDTO ticketResponseDTO = chatClient
                .prompt()
                .user( companySpecificPrompt + "\n\nCustomer Complaint:\n" + issue)
                .call()
                 .entity(TicketResponseDTO.class);

         ticketResponseDTO.setEmail(email);
         ticketSaverService.saveTicket(email, issue, ticketResponseDTO);

        return ticketResponseDTO;
    }
}
