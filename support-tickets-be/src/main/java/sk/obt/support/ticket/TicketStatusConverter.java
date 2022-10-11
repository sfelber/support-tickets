package sk.obt.support.ticket;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Attribute converter for {@link TicketStatus}.
 * 
 * @author sfelber
 * @since 07.10.2022
 */
@Converter(autoApply = true)
public class TicketStatusConverter implements AttributeConverter<TicketStatus, String>{

	@Override
	public String convertToDatabaseColumn(TicketStatus status) {
		if (status == null) {
			return null;
		}
		return status.getCode();
	}

	@Override
	public TicketStatus convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}
		
		return Stream.of(TicketStatus.values())
				.filter(s -> s.getCode().equals(code))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	
}
