package br.com.treinamento.cadastrarclientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinamento.cadastrarclientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
