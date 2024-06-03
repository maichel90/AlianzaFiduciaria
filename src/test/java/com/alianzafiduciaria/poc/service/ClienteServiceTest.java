package com.alianzafiduciaria.poc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.alianzafiduciaria.poc.dto.ClienteDTO;
import com.alianzafiduciaria.poc.model.Cliente;
import com.alianzafiduciaria.poc.repository.ClienteRepository;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {
	
	@Mock
	private  ClienteRepository clienteRepository;
	
	@InjectMocks
	private  ClienteService clienteService;

	@Test
	void createClienteService() {
		ClienteDTO clientedto = createClienteDTO();
		Cliente cliente = createCliente();
		when(clienteRepository.findById(cliente.getSharedKey())).thenReturn(Optional.empty());
		when(clienteRepository.save(cliente)).thenReturn(cliente);
		ClienteDTO result = clienteService.createCliente(clientedto);
		assertEquals(clientedto, result);
	}
	
	@Test
	void clienteExist() {
		ClienteDTO clientedto = createClienteDTO();
		Cliente cliente = createCliente();
		when(clienteRepository.findById(cliente.getSharedKey())).thenReturn(Optional.of(cliente));
		ClienteDTO result = clienteService.createCliente(clientedto);
		assertEquals(null, result);
	}
	
	@Test
	void getClienteExist() {
		ClienteDTO clientedto = createClienteDTO();
		Cliente cliente = createCliente();
		when(clienteRepository.findById(cliente.getSharedKey())).thenReturn(Optional.of(cliente));
		ClienteDTO result = clienteService.getClienteBySharedkey(cliente.getSharedKey());
		assertEquals(clientedto, result);
	}
	
	@Test
	void getClienteNoExist() {
		when(clienteRepository.findById("TEST")).thenReturn(Optional.empty());
		ClienteDTO result = clienteService.getClienteBySharedkey("TEST");
		assertEquals(null, result);
	}
	
	@Test
	void findAllClients() {
		Cliente cliente = createCliente();
		List<Cliente> list = new ArrayList<>();
		list.add(cliente);
		
		ClienteDTO clientedto = createClienteDTO();
		List<ClienteDTO> listdto = new ArrayList<>();
		listdto.add(clientedto);
		
		when(clienteRepository.findByRemovedFalse()).thenReturn(list);
		List<ClienteDTO> resultlist = clienteService.getAllClientes();
		assertEquals(listdto, resultlist);
	}
	
	Cliente createCliente() {
		Cliente cliente = new Cliente();
		cliente.setBussinesId("Albert Maichel");
		cliente.setCreateDate(new Date((long)1714539600*1000));
		cliente.setEmail("a@gmail.com");
		cliente.setPhone("300000");
		cliente.setRemoved(false);
		cliente.setSharedKey("amiahcel");
		return cliente;
	}
	
	ClienteDTO createClienteDTO() {
		ClienteDTO cliente = new ClienteDTO();
		cliente.setBussinesId("Albert Maichel");
		cliente.setCreateDate(new Date((long)1714539600*1000));
		cliente.setEmail("a@gmail.com");
		cliente.setPhone("300000");
		cliente.setRemoved(false);
		cliente.setSharedKey("amiahcel");
		return cliente;
	}

}
