package br.com.gva.wisedelivery.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gva.wisedelivery.dominio.Cliente;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("clientes")
public class ClienteController {

    Logger logg = LoggerFactory.getLogger(ClienteController.class);
    
    @GetMapping("form-cadastro")
    public String formCadastroCliente( Model model ){
        model.addAttribute("cliente", new Cliente());
        return "cliente-cadastro";
    }

    @PostMapping("/save")
    public String salvarCliente( @ModelAttribute("cliente") Cliente cliente) {
        logg.info("CLIENTE SALVO: " + cliente.getNome());        
        return "cliente-cadastro";
    }
}