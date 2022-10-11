package sk.obt.support.ticket;

/**
 * Ticket can hold different status (states).
 * 
 * @author sfelber
 * @since 07.10.2022
 */
public enum TicketStatus {

	TODO("T"),
	DOING("I"),
	DONE("D");
	
	private final String code;
	
	private TicketStatus(final String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
}
