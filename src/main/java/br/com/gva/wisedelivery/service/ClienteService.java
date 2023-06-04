package br.com.gva.wisedelivery.service;

import br.com.gva.wisedelivery.dominio.dto.clientedto.ClienteDTO;
import br.com.gva.wisedelivery.dominio.dto.clientedto.ClienteIdDTO;
import br.com.gva.wisedelivery.dominio.dto.clientedto.ClienteLoginDTO;
import br.com.gva.wisedelivery.dominio.dto.clientedto.ClienteSalvoDTO;

public interface ClienteService {
   ClienteSalvoDTO salvar(ClienteDTO dto);

   ClienteSalvoDTO procurarPeloId(Long id);

    boolean login(ClienteLoginDTO cliente);

    ClienteIdDTO procurarCliente(String email);

}