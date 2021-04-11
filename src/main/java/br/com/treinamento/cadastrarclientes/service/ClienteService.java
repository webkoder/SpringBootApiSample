package br.com.treinamento.cadastrarclientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinamento.cadastrarclientes.model.Cliente;
import br.com.treinamento.cadastrarclientes.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> listAllCliente(){
		return clienteRepository.findAll();
		
	}
	
	public Cliente getCliente(Integer id) {
		return clienteRepository.findById(id).get();
	}
	
	public void saveCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public void deleteCliente(Integer id) {
		clienteRepository.deleteById(id);
	}
}
