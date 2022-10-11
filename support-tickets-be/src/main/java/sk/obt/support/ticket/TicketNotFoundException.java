package sk.obt.support.ticket;

public class TicketNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 521474199150759163L;

	TicketNotFoundException(Long id) {
		super("Could not found ticket " + id);
	}

}
