package com.alianzafiduciaria.poc.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.alianzafiduciaria.poc.dto.ClienteDTO;
import com.alianzafiduciaria.poc.model.Cliente;

@Mapper
public interface IClienteMapper {
	
	IClienteMapper INSTANCE = Mappers.getMapper( IClienteMapper.class );
	
	ClienteDTO entityToDto(Cliente cliente);
	
	Cliente dtoToEntity(ClienteDTO clienteDTO);
	
	List<ClienteDTO> entityToDtoList(List<Cliente> clienteList);

}
