package in.taste.foodiees.controller;

import in.taste.foodiees.dto.TicketRequestDTO;
import in.taste.foodiees.dto.TicketResponseDTO;
import in.taste.foodiees.service.TicketSummarizerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TicketSummarizerController {

    private TicketSummarizerService ticketSummarizerService;

    @Autowired
    public TicketSummarizerController(TicketSummarizerService ticketSummarizerService) {
        this.ticketSummarizerService = ticketSummarizerService;
    }

    @PostMapping("/summarize")
    public TicketResponseDTO summarize(@Valid @RequestBody TicketRequestDTO ticketRequestDTO) {
        TicketResponseDTO result = ticketSummarizerService.summarize(ticketRequestDTO.getEmail(), ticketRequestDTO.getIssue());
        return result;
    }
}
