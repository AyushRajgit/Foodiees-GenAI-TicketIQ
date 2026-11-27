package in.taste.foodiees.repository;

import in.taste.foodiees.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketSaverRepository extends JpaRepository<Ticket,Long> {

    public Ticket save(Ticket ticket);

    public List<Ticket> findAll();

    public Ticket findById(long id);

    public Ticket findByEmail(String email);

    public boolean existsById(long id);

    public boolean existsByEmail(String email);

    public void deleteById(long id);

    public void deleteByEmail(Ticket ticket);
}
