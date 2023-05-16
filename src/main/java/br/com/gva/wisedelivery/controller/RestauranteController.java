package br.com.gva.wisedelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gva.wisedelivery.dominio.dto.restaurantedto.RestauranteDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.RestauranteLoginDTO;
import br.com.gva.wisedelivery.service.RestauranteService;
import jakarta.validation.Valid;
import lombok.Getter;

@Controller
@RequestMapping("restaurantes")
public class RestauranteController {

    @Autowired @Getter
    private RestauranteService restauranteService;
    
    @GetMapping("login")
    public  String formLogin(Model model){
        model.addAttribute("restaurante", new RestauranteLoginDTO());
        return "login-restaurante";
    }

    @PostMapping("logar")
    public String logar(@ModelAttribute("restaurante") RestauranteLoginDTO restaurante, Model model) {
        if(!getRestauranteService().logar(restaurante)){
            return "login-restaurante";
        }
        
        var restauranteId = getRestauranteService().procurarRestauranteIdPeloEmail(restaurante.getEmail());
        model.addAttribute("restauranteId", restauranteId);
        return home(model);
    }

    @GetMapping("form-cadastro")
    String formCadastroRestaurante(Model model) {
        model.addAttribute("categorias", restauranteService.pegaTodasAsCategorias());
        model.addAttribute("restaurante", new RestauranteDTO());
        
        return "restaurante-cadastro";
    }

    @PostMapping("salvar")
    public String salvarRestaurante(@ModelAttribute("restaurante") @Valid RestauranteDTO dto) {
        restauranteService.salvar(dto);
        return "restaurante-cadastro";
    }

    @GetMapping("/admin/dashboard")
    public String home(Model model) {

        return "restaurante-dashboard";
    }
    
}