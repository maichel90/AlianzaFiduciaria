package com.alianzafiduciaria.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alianzafiduciaria.poc.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{
	
	List<Cliente> findByRemovedFalse();

}
