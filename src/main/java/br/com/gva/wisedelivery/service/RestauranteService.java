package br.com.gva.wisedelivery.service;

import java.util.List;

import br.com.gva.wisedelivery.dominio.RestauranteCategoria;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.RestauranteDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.RestauranteLoginDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.RestauranteSalvoDTO;

public interface RestauranteService {

    RestauranteSalvoDTO procurarPeloEmail(String email);

    RestauranteSalvoDTO salvar(RestauranteDTO dto);

    List<RestauranteCategoria> pegaTodasAsCategorias();

    boolean logar(RestauranteLoginDTO restaurante);
}