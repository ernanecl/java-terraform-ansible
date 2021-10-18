package com.spring.danilo.web.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.spring.danilo.web.teste.models.Cliente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class TesteApplicationTests {

	@DisplayName("Testando instancia de um objeto")
	@Test
	void instanciaClienteDanilo() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo"); 
		assertEquals("Danilo", cliente.getNome());
	}


	@Test
	void instanciaClienteJoao() {
		Cliente cliente = new Cliente();
		cliente.setNome("Joao");
		assertEquals(cliente.getNome(), "Joao");
	}
}
