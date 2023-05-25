package br.com.gva.wisedelivery.controller;

import br.com.gva.wisedelivery.dominio.dto.restaurantedto.ItemCardapioDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.ItemCardapioTabelaDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.ItemCarrinhoDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.RestauranteIdDTO;
import br.com.gva.wisedelivery.service.ItemCardapioService;
import br.com.gva.wisedelivery.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import br.com.gva.wisedelivery.controller.validator.Validator;
import br.com.gva.wisedelivery.dominio.dto.clientedto.ClienteDTO;
import br.com.gva.wisedelivery.dominio.dto.clientedto.ClienteLoginDTO;
import br.com.gva.wisedelivery.exception.SenhaInvalidaException;
import br.com.gva.wisedelivery.service.ClienteService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.util.List;

@Log4j2
@Controller
@RequestMapping("clientes")
public class ClienteController {

    public ClienteController(RestauranteService restauranteService){
        this.restauranteService = restauranteService;
    }

    @Getter private final RestauranteService restauranteService;

    @Autowired
    @Getter private ClienteService clienteService;

    @Autowired
    @Getter private ItemCardapioService itemCardapioService;

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

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("restaurantes", getRestauranteService().procurarTodos());
        return "cliente-home";
    }

    @GetMapping("restaurantes/{restauranteId}")
    public String clienteRestauranteCardapio(Model model, @PathVariable("restauranteId") Long restauranteId) {
        List<ItemCardapioTabelaDTO> itensCardapioRestaurante = getItemCardapioService().procurarTodosOsItensPeloIdDoRestaurante(restauranteId);
        //List<ItemCardapioTabelaDTO> itensEmDestaque = itensCardapioRestaurante.stream().filter( item -> item.isDestaque()).toList();
        List<ItemCardapioTabelaDTO> itensEmDestaque = getItemCardapioService().procurarTodosOsItensPeloIdDoRestauranteEQueEstejamEmDestaque(restauranteId);
        RestauranteIdDTO restaurante = getRestauranteService().procurarRestaurantePeloId(restauranteId);
        model.addAttribute("restaurante", restaurante);
        model.addAttribute("itensEmDestaque", itensEmDestaque);
        model.addAttribute("itensCardapioRestaurante", itensCardapioRestaurante);
        return "cliente-restaurante-cardapio";
    }

    @GetMapping("restaurantes/{restauranteId}/itens/{itemId}")
    public String clienteRestauranteCardapioItem(Model model, @PathVariable("itemId") Long itemId) {
        model.addAttribute("item", getItemCardapioService().procurarPeloId(itemId));
        model.addAttribute("itemCarrinho", new ItemCarrinhoDTO());
        return "cliente-restaurante-itemcardapio";
    }

    @PostMapping("carrinho/add/{itemId}")
    public String adicionaItemAoCarrinho(@ModelAttribute("itemCarrinho")ItemCarrinhoDTO itemCarrinhoDTO, @PathVariable("itemId") Long itemId, Model model) {
        model.addAttribute("item", getItemCardapioService().procurarPeloId(1L));
        return "cliente-restaurante-itemcardapio";
    }
}