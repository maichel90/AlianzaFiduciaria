package com.alianzafiduciaria.poc.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alianzafiduciaria.poc.dto.ClienteDTO;
import com.alianzafiduciaria.poc.mapper.IClienteMapper;
import com.alianzafiduciaria.poc.model.Cliente;
import com.alianzafiduciaria.poc.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteDTO createCliente(ClienteDTO clienteDTO) {
		Cliente cliente = IClienteMapper.INSTANCE.dtoToEntity(clienteDTO);
		Optional<Cliente> optionalCliente =  clienteRepository.findById(cliente.getSharedKey());
		if(optionalCliente.isPresent()) {
			return null;
		}
		if(cliente.getCreateDate()==null) {
			cliente.setCreateDate(new Date());
		}		
		cliente.setRemoved(false);
		cliente = clienteRepository.save(cliente);
		return IClienteMapper.INSTANCE.entityToDto(cliente);
	}
	
	public ClienteDTO getClienteBySharedkey(String sharedkey) {
		Optional<Cliente> optionalCliente =  clienteRepository.findById(sharedkey);
		if(optionalCliente.isPresent()) {
			return IClienteMapper.INSTANCE.entityToDto(optionalCliente.get());
		}
		return null;
	}
	
	public List<ClienteDTO> getAllClientes() {
		List<Cliente> allClientes =  clienteRepository.findByRemovedFalse();
		return IClienteMapper.INSTANCE.entityToDtoList(allClientes);
	}

}
