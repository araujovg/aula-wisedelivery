package br.com.gva.wisedelivery.service;

import br.com.gva.wisedelivery.dominio.dto.ClienteDTO;
import br.com.gva.wisedelivery.dominio.dto.ClienteLoginDTO;
import br.com.gva.wisedelivery.dominio.dto.ClienteSalvoDTO;

public interface ClienteService {
   ClienteSalvoDTO salvar(ClienteDTO dto);

    boolean login(ClienteLoginDTO cliente);
}