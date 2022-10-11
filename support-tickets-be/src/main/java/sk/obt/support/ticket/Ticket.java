package sk.obt.support.ticket;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * A ticket consists of an id, a title, a status (TODO, DOING, DONE), a description and a date of creation. 
 * The ID of the ticket is unique 
 * I can change the title, description and status of a ticket
 *  
 * @author sfelber
 * @since 06.10.2022
 */
@Entity
public class Ticket {

	@Id
	@GeneratedValue
	private long id;
	
	private String title;
	
	private TicketStatus status;
	
	@Column(length = 4000)
	private String description;
	
	/**
	 * Time stamp of last modification.
	 * In case when ticket is created, field is set to current time.
	 */
	private Date modified;

	// 
	// Constructors
	//
	
	/**
	 * Empty constructor
	 */
	Ticket() {
	}

	/**
	 * Constructor
	 * 
	 * @param title
	 * @param description
	 */
	Ticket(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	// 
	// Getters & Setters
	//

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
	
	//
	// Other routines
	//
		
	@Override
	public int hashCode() {
		return Objects.hash(description, id, modified, status, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(modified, other.modified) && Objects.equals(status, other.status)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", title=" + title + ", status=" + status + ", modified=" + modified + "]";
	}
	
	
}
