package com.alianzafiduciaria.poc.mapper;

import com.alianzafiduciaria.poc.dto.ClienteDTO;
import com.alianzafiduciaria.poc.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-03T15:25:28-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class IClienteMapperImpl implements IClienteMapper {

    @Override
    public ClienteDTO entityToDto(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setSharedKey( cliente.getSharedKey() );
        clienteDTO.setBussinesId( cliente.getBussinesId() );
        clienteDTO.setEmail( cliente.getEmail() );
        clienteDTO.setPhone( cliente.getPhone() );
        clienteDTO.setCreateDate( cliente.getCreateDate() );
        if ( cliente.getRemoved() != null ) {
            clienteDTO.setRemoved( cliente.getRemoved() );
        }

        return clienteDTO;
    }

    @Override
    public Cliente dtoToEntity(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setSharedKey( clienteDTO.getSharedKey() );
        cliente.setBussinesId( clienteDTO.getBussinesId() );
        cliente.setEmail( clienteDTO.getEmail() );
        cliente.setPhone( clienteDTO.getPhone() );
        cliente.setCreateDate( clienteDTO.getCreateDate() );
        cliente.setRemoved( clienteDTO.isRemoved() );

        return cliente;
    }

    @Override
    public List<ClienteDTO> entityToDtoList(List<Cliente> clienteList) {
        if ( clienteList == null ) {
            return null;
        }

        List<ClienteDTO> list = new ArrayList<ClienteDTO>( clienteList.size() );
        for ( Cliente cliente : clienteList ) {
            list.add( entityToDto( cliente ) );
        }

        return list;
    }
}
