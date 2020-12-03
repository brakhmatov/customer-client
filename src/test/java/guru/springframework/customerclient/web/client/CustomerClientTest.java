package guru.springframework.customerclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.customerclient.web.model.CustomerDto;

@SpringBootTest
class CustomerClientTest {

	@Autowired
	CustomerClient client;

	@Test
	void testGetCustomerById() {
		CustomerDto dto = client.getCustomerById(UUID.randomUUID());
		assertNotNull(dto);
	}

	@Test
	void testSaveCustomer() {
		// given
		CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).build();

		URI uri = client.saveNewCustomer(customerDto);

		assertNotNull(uri);

		System.out.println(uri.toString());
	}

	@Test
	void testPutCustomer() {
		// given
		CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).build();
		client.putCustomer(UUID.randomUUID(), customerDto);
	}

	@Test
	void testDeleteCustomer() {
		client.deleteCustomer(UUID.randomUUID());
	}

}
