package br.com.gva.wisedelivery.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gva.wisedelivery.dominio.dto.clientedto.ClienteDTO;
import br.com.gva.wisedelivery.dominio.dto.clientedto.ClienteIdDTO;
import br.com.gva.wisedelivery.dominio.dto.clientedto.ClienteLoginDTO;
import br.com.gva.wisedelivery.dominio.dto.clientedto.ClienteSalvoDTO;
import br.com.gva.wisedelivery.dominio.entidades.cliente.Cliente;
import br.com.gva.wisedelivery.exception.ObjetoNaoEncontradoException;
import br.com.gva.wisedelivery.repository.ClienteRepository;
import br.com.gva.wisedelivery.service.ClienteService;
import lombok.Getter;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    @Getter
    private ClienteRepository clienteRepository;

    @Override
    public ClienteSalvoDTO salvar(ClienteDTO dto) {
        return deClienteParaClienteSalvoDto(
                getClienteRepository().save(
                        deDtoParaCliente(dto)));
    }

    @Override
    public boolean login(ClienteLoginDTO cliente) {
        Cliente clienteSalvo = getClienteRepository().findByEmail(cliente.getEmail()).orElseThrow(
                () -> new ObjetoNaoEncontradoException("Não foi encontrado um cliente para o email passado"));
        return cliente.getEmail().equals(clienteSalvo.getEmail()) && cliente.getSenha().equals(clienteSalvo.getSenha());
    }

    private Cliente deDtoParaCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(dto, cliente, "confirmaSenha");
        return cliente;
    }

    private ClienteSalvoDTO deClienteParaClienteSalvoDto(Cliente cliente) {
        ClienteSalvoDTO clienteSalvoDTO = new ClienteSalvoDTO();
        BeanUtils.copyProperties(cliente, clienteSalvoDTO, "senha", "confirmaSenha");
        return clienteSalvoDTO;
    }

    private ClienteIdDTO deCLienteParaClienteIdDto(Cliente cliente){
        ClienteIdDTO clienteIdDTO = new ClienteIdDTO();
        clienteIdDTO.setId(cliente.getId());
        return clienteIdDTO;
    }

    @Override
    public ClienteIdDTO procurarCliente(String email) {
        Cliente cliente = getClienteRepository().findByEmail(email).orElseThrow( () -> new ObjetoNaoEncontradoException(String.format("Cliente não encontrado para o email: [%s]", email)));
        return deCLienteParaClienteIdDto(cliente);
    }

    @Override
    public ClienteSalvoDTO procurarPeloId(Long id) {
        Cliente cliente = getClienteRepository().findById(id).orElseThrow( () -> new ObjetoNaoEncontradoException(String.format("Cliente não encontrado para o id: [%s]", id)));
        return deClienteParaClienteSalvoDto(cliente);
    }

}
