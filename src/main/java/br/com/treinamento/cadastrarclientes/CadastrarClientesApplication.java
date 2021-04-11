package br.com.treinamento.cadastrarclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CadastrarClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastrarClientesApplication.class, args);
	}

}
