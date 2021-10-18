package com.spring.danilo.web.teste.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.spring.danilo.web.teste.models.Cliente;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TesteApplicationTests {
	public Cliente cliente;

	@BeforeEach
	public void criaCliente(){
		cliente = new Cliente();
	}

	@DisplayName("Dado que eu tenha um CPF válido formatado, então e devo retornar verdadeiro")
	@Test
	void cpfValidoFormatado() {
		cliente.setCpf("261.627.370-55");
		assertEquals(cliente.validarCpf(), true);
	}

	@DisplayName("Dado que eu tenha um CPF válido, então e devo retornar verdadeiro")
	@Test
	void cpfValido() {
		cliente.setCpf("26162737055");
		assertEquals(cliente.validarCpf(), true);
	}

	@DisplayName("Dado que eu tenha um CPF inválido, então e devo retornar falso")
	@Test
	void cpfInvalido() {
		cliente.setCpf("26162717055");
		assertEquals(cliente.validarCpf(), false);
	}

	@DisplayName("Dado que eu tenha um CPF inválido formatado, então e devo retornar falso")
	@Test
	void cpfInvalidoFormatado() {
		cliente.setCpf("261.627.170-55");
		assertEquals(cliente.validarCpf(), false);
	}

	@DisplayName("Dado que eu tenha um CPF nulo, então e devo retornar falso")
	@Test
	void cpfNulo() {
		cliente.setCpf(null);
		assertEquals(cliente.validarCpf(), false);
	}

	@DisplayName("Dado que eu tenha um CPF branco, então e devo retornar falso")
	@Test
	void cpfBranco() {
		cliente.setCpf("");
		assertEquals(cliente.validarCpf(), false);
	}

	@DisplayName("Dado que eu tenha um CPF 11111111111, então e devo retornar falso")
	@Test
	void cpfComNumeroAMais() {
		cliente.setCpf("");
		assertEquals(cliente.validarCpf(), false);
	}


}
