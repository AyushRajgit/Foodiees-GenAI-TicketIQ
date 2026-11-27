package in.taste.foodiees.dto;

import in.taste.foodiees.enums.TicketCategory;
import in.taste.foodiees.enums.TicketPriority;
import in.taste.foodiees.enums.TicketSentiment;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponseDTO {
    private String email;
    private String summary;

    private TicketCategory ticketCategory;
    private TicketPriority ticketPriority;
    private TicketSentiment ticketSentiment;

    private String suggestedAction;
}
