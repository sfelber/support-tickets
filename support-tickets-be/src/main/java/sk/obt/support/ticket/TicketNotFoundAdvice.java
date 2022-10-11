package sk.obt.support.ticket;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller advice to handle exceptions from {@link TicketController}.
 * 
 * @author sfelber
 * @since 06.10.2022
 */
@ControllerAdvice
public class TicketNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(TicketNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String ticketNotFoundHandler(TicketNotFoundException e) {
		return e.getMessage();
	}
}
