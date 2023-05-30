package br.com.gva.wisedelivery.service;

import java.util.List;

import br.com.gva.wisedelivery.dominio.dto.restaurantedto.RestauranteDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.RestauranteIdDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.RestauranteLoginDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.RestauranteSalvoDTO;
import br.com.gva.wisedelivery.dominio.entidades.restaurante.RestauranteCategoria;

public interface RestauranteService {

    RestauranteIdDTO procurarRestauranteIdPeloEmail(String email);

    RestauranteIdDTO procurarRestaurantePeloId(Long id);

    RestauranteSalvoDTO procurarPeloEmail(String email);

    RestauranteSalvoDTO salvar(RestauranteDTO dto);

    List<RestauranteCategoria> pegaTodasAsCategorias();

    boolean logar(RestauranteLoginDTO restaurante);

    List<RestauranteDTO> procurarTodos();
}