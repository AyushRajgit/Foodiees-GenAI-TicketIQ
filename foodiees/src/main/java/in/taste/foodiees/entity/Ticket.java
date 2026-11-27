package in.taste.foodiees.entity;

import in.taste.foodiees.enums.TicketCategory;
import in.taste.foodiees.enums.TicketPriority;
import in.taste.foodiees.enums.TicketSentiment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Tickets")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketId;

    @Column(nullable = false)
    private String email;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String originalIssue;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String summary;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketPriority priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketSentiment sentiment;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String suggestedAction;

    public Ticket(String email, String originalIssue, String summary, TicketCategory category, TicketPriority priority, TicketSentiment sentiment, String suggestedAction) {
        this.email = email;
        this.originalIssue = originalIssue;
        this.summary = summary;
        this.category = category;
        this.priority = priority;
        this.sentiment = sentiment;
        this.suggestedAction = suggestedAction;
    }
}
