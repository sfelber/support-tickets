package sk.obt.support.ticket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author sfelber
 * @since 06.10.2022
 */
@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
	
}
