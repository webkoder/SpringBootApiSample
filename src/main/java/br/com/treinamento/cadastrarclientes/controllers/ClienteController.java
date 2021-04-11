package br.com.treinamento.cadastrarclientes.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.cadastrarclientes.model.Cliente;
import br.com.treinamento.cadastrarclientes.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("")
	public List<Cliente> list() {
		return clienteService.listAllCliente();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> get(@PathVariable Integer id) {
		try {
			Cliente cliente = clienteService.getCliente( id );
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
	}
	

	@PostMapping("")
	public ResponseEntity<String> add(@RequestBody Cliente cliente) {
		clienteService.saveCliente( cliente );
		return new ResponseEntity<String>("Cliente Adicionado", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
		try {
			cliente.setId(id);
			clienteService.saveCliente(cliente);
			return new ResponseEntity<String>("Cliente Atualizado", HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping("/{id}/salario")
	public ResponseEntity<?> updateSalario(@PathVariable Integer id, @RequestBody Cliente salario) {
		try {
			Cliente clienteAtual = clienteService.getCliente(id);
			clienteAtual.setId(id);
			clienteAtual.setSalario(salario.getSalario());
			clienteService.saveCliente(clienteAtual);
			return new ResponseEntity<String>("Cliente Atualizado", HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		clienteService.deleteCliente(id);
	}
}
