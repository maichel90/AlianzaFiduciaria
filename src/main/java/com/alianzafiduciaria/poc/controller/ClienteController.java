package com.alianzafiduciaria.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alianzafiduciaria.poc.dto.ClienteDTO;
import com.alianzafiduciaria.poc.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Object> createCliente(@RequestBody ClienteDTO clienteDTO){
		clienteDTO = clienteService.createCliente(clienteDTO);
		if(clienteDTO == null)
			return new ResponseEntity<>(clienteDTO,HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(clienteDTO,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<Object> getAllClientes(){
		List<ClienteDTO> clientes = clienteService.getAllClientes();
		return new ResponseEntity<>(clientes,HttpStatus.OK);
	}
	
	@GetMapping("/sharedkey")
	public ResponseEntity<Object> getClienteBySharedKey(@RequestParam String sharedkey){
		ClienteDTO clienteDTO = clienteService.getClienteBySharedkey(sharedkey);
		return new ResponseEntity<>(clienteDTO,HttpStatus.OK);
	}

}
