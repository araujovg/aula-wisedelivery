package br.com.gva.wisedelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gva.wisedelivery.controller.validator.Validator;
import br.com.gva.wisedelivery.dominio.dto.clientedto.ClienteDTO;
import br.com.gva.wisedelivery.dominio.dto.clientedto.ClienteLoginDTO;
import br.com.gva.wisedelivery.exception.SenhaInvalidaException;
import br.com.gva.wisedelivery.service.ClienteService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    @Getter private ClienteService clienteService;

    @Autowired
    @Getter private Validator<ClienteDTO> validator;
    
    @GetMapping("form-cadastro")
    public String formCadastroCliente( Model model ){
        model.addAttribute("cliente", new ClienteDTO());
        return "cliente-cadastro";
    }

    @PostMapping("/save")
    public String salvarCliente( @ModelAttribute("cliente") @Valid ClienteDTO cliente, BindingResult result ) {
        if(validator.validator(cliente)){
            log.error("Senha e confirmação não estão batendo", cliente);
            throw new SenhaInvalidaException("Senha e confirmação não estão batendo");
        }
        getClienteService().salvar(cliente);
        log.info(String.format("Cliente salvo. Nome: [%s]", cliente.getNome()));
        return "cliente-cadastro-ok";
    }

    @GetMapping("/login")
    public String telaLogin(Model model){
        model.addAttribute("cliente", new ClienteLoginDTO());
        return "login";
    }

    @PostMapping("/logar")
    public String login(@ModelAttribute("cliente") ClienteLoginDTO cliente){
        if(!getClienteService().login(cliente)) {
            return "login";
        }
        return "cliente-home";        
    }
}