package in.taste.foodiees.repository;

import in.taste.foodiees.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketSaverRepository extends JpaRepository<Ticket,Long> {

    public Ticket save(Ticket ticket);

}
