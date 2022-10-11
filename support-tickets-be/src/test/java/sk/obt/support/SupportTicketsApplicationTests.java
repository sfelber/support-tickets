package sk.obt.support;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class SupportTicketsApplicationTests {

	
	@Autowired
	private TestRestTemplate rest;
	
	@Test
	void contextLoads() {
		final String baseUrl = "http://localhost:8080";
		assertThat(rest.getForEntity(baseUrl + "/tickets/1", String.class).getStatusCode())
		.isEqualTo(HttpStatus.NOT_FOUND);
	}
	


}
