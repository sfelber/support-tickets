package sk.obt.support.ticket;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author sfelber
 * @since 06.10.2022
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {

	private final TicketRepository repository;
	
	TicketController(TicketRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/tickets")
	List<Ticket> getTickets() {
		List<Ticket> result = (List<Ticket>) repository.findAll();
		return result;
	}
	
	@PostMapping("/tickets")
	Ticket newTicket(@RequestBody Ticket ticket) {
		ticket.setModified(new Date());
		ticket.setStatus(TicketStatus.TODO);
		return repository.save(ticket);
	}

	@GetMapping("/tickets/{id}")
	Ticket getTicket(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
	}
	
	@PutMapping("/tickets/{id}")
	Ticket updateTicket(@RequestBody Ticket updatedTicket, @PathVariable Long id) {
		Ticket ticket = repository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
		ticket.setTitle(updatedTicket.getTitle());
		ticket.setDescription(updatedTicket.getDescription());
		ticket.setStatus(updatedTicket.getStatus());
		ticket.setModified(new Date());
		return repository.save(ticket);
	}
	
	@DeleteMapping("/tickets/{id}")
	void removeTicket(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	
}
