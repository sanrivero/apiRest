package com.example.api.dto.mapper;

import com.example.api.dto.response.ClienteResponseDTO;
import com.example.api.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {

    ClienteMapper mapper = Mappers.getMapper(ClienteMapper.class);

    ClienteResponseDTO clienteToResp(Cliente cliente);

}
