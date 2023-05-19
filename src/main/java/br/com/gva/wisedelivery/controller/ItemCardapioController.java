package br.com.gva.wisedelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gva.wisedelivery.dominio.dto.restaurantedto.ItemCardapioDTO;
import br.com.gva.wisedelivery.service.ItemCardapioService;
import lombok.Getter;

@RequestMapping("admin/itens-cardapio")
@Controller
public class ItemCardapioController {

    @Autowired @Getter
    private ItemCardapioService itemCardapioService;
    
    @GetMapping("form-itemcardapio/{restauranteId}")
    public String formItemCardapio(Model model, @PathVariable("restauranteId") Long restauranteId){
        model.addAttribute("itens", itemCardapioService.procurarTodosOsItensPeloIdDoRestaurante(restauranteId));
        model.addAttribute("categorias", itemCardapioService.pegarTodasAsCategorias());
        model.addAttribute("itemCardapio", new ItemCardapioDTO());
        return "restaurante-dashboard-itemcardapio";
    }

    @PostMapping("salvar")
    public String salvar(@ModelAttribute("itemCardapio") ItemCardapioDTO itemCardapio){
        getItemCardapioService().salvar(itemCardapio);
        return "restaurante-dashboard-itemcardapio";
    }

}