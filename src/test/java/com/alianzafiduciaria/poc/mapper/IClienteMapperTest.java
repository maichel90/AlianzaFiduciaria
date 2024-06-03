package com.alianzafiduciaria.poc.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.alianzafiduciaria.poc.dto.ClienteDTO;
import com.alianzafiduciaria.poc.model.Cliente;

class IClienteMapperTest {

	@Test
	void entityToDto() {
		Cliente cliente = createCliente();
		ClienteDTO clienteResult = createClienteDTO();
		ClienteDTO result = IClienteMapper.INSTANCE.entityToDto(cliente);
		assertEquals(clienteResult, result);
	}
	
	@Test
	void dtoToEntity() {
		Cliente cliente = createCliente();
		ClienteDTO clientedto = createClienteDTO();
		Cliente result = IClienteMapper.INSTANCE.dtoToEntity(clientedto);
		assertEquals(cliente, result);
	}
	
	@Test
	void entityToDtoList() {
		
		Cliente cliente = createCliente();
		List<Cliente> list = new ArrayList<>();
		list.add(cliente);
		
		ClienteDTO clientedto = createClienteDTO();
		List<ClienteDTO> listdto = new ArrayList<>();
		listdto.add(clientedto);

		List<ClienteDTO> result = IClienteMapper.INSTANCE.entityToDtoList(list);
		assertEquals(listdto, result);
	}
	
	@Test
	void objectsNull() {
		Cliente cliente = null;
		ClienteDTO clientedto = null;
		List<Cliente> list = null;
		
		ClienteDTO result = IClienteMapper.INSTANCE.entityToDto(cliente);
		Cliente resultdto = IClienteMapper.INSTANCE.dtoToEntity(clientedto);
		List<ClienteDTO> resultlist = IClienteMapper.INSTANCE.entityToDtoList(list);
		
		assertEquals(result, null);
		assertEquals(resultdto, null);
		assertEquals(resultlist, null);
	}
	
	Cliente createCliente() {
		Cliente cliente = new Cliente();
		cliente.setBussinesId("Albert Maichel");
		cliente.setCreateDate(new Date((long)1714539600*1000));
		cliente.setEmail("a@gmail.com");
		cliente.setPhone("300000");
		cliente.setRemoved(true);
		cliente.setSharedKey("amiahcel");
		return cliente;
	}
	
	ClienteDTO createClienteDTO() {
		ClienteDTO cliente = new ClienteDTO();
		cliente.setBussinesId("Albert Maichel");
		cliente.setCreateDate(new Date((long)1714539600*1000));
		cliente.setEmail("a@gmail.com");
		cliente.setPhone("300000");
		cliente.setRemoved(true);
		cliente.setSharedKey("amiahcel");
		return cliente;
	}

}
