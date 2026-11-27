package in.taste.foodiees.service;

import in.taste.foodiees.dto.TicketResponseDTO;
import in.taste.foodiees.entity.Ticket;
import in.taste.foodiees.repository.TicketSaverRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketSaverService {

    private TicketSaverRepository ticketSaverRepository;

    public TicketSaverService(TicketSaverRepository ticketSaverRepository) {
        this.ticketSaverRepository = ticketSaverRepository;
    }

    public void saveTicket(String email, String issue, TicketResponseDTO ticketResponse) {
        Ticket ticket = new Ticket(
                email,
                issue,
                ticketResponse.getSummary(),
                ticketResponse.getTicketCategory(),
                ticketResponse.getTicketPriority(),
                ticketResponse.getTicketSentiment(),
                ticketResponse.getSuggestedAction()
        );

        ticketSaverRepository.save(ticket);
    }
}
