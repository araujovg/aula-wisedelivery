package br.com.gva.wisedelivery.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gva.wisedelivery.dominio.Restaurante;
import br.com.gva.wisedelivery.dominio.RestauranteCategoria;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.RestauranteDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.RestauranteLoginDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.RestauranteSalvoDTO;
import br.com.gva.wisedelivery.exception.ObjetoNaoEncontradoException;
import br.com.gva.wisedelivery.repository.RestauranteCategoriaRepository;
import br.com.gva.wisedelivery.repository.RestauranteRepository;
import br.com.gva.wisedelivery.service.RestauranteService;
import lombok.Getter;

@Service
public class RestauranteServiceImpl implements RestauranteService{

    @Autowired
    @Getter
    private RestauranteRepository restauranteRepository;

    @Autowired
    @Getter
    private RestauranteCategoriaRepository restauranteCategoriaRepository;

    @Autowired
    @Getter
    private ImageServiceImpl imageService;

    @Override
    public RestauranteSalvoDTO salvar(RestauranteDTO dto) {
        //dto.setLogotipo(imageService.uploadImagem(dto.getArquivoLogotipo()));
        imageService.uploadImagem(dto.getArquivoLogotipo());
        return 
            deRestauranteParaRestauranteSalvoDto(
                getRestauranteRepository().save(
                    deDtoParaRestaurante(dto)
                )
            );
    }

    @Override
    public List<RestauranteCategoria> pegaTodasAsCategorias() {
        return getRestauranteCategoriaRepository().findAll();
    }

    private Restaurante deDtoParaRestaurante(RestauranteDTO dto){
        Restaurante restaurante = new Restaurante();
        BeanUtils.copyProperties(dto, restaurante, "confirmaSenha");
        return restaurante;
    }

    private RestauranteSalvoDTO deRestauranteParaRestauranteSalvoDto(Restaurante restaurante){
        RestauranteSalvoDTO dto = new RestauranteSalvoDTO();
        BeanUtils.copyProperties(restaurante, dto,"confirmaSenha");
        return dto;
    }

    @Override
    public boolean logar(RestauranteLoginDTO restaurante) {
        Restaurante restauranteBanco = getRestauranteRepository().findByEmail(restaurante.getEmail()).orElseThrow(
            () -> new ObjetoNaoEncontradoException("Não foi encontrado um restaurante para o e-mail passado"));
        return restaurante.getEmail().equals(restauranteBanco.getEmail())
            && restaurante.getSenha().equals(restauranteBanco.getSenha());
    }

    @Override
    public RestauranteSalvoDTO procurarPeloEmail(String email) {
        return deRestauranteParaRestauranteSalvoDto(getRestauranteRepository().findByEmail(email).orElseThrow(
            () -> new ObjetoNaoEncontradoException("Não foi encontrado um restaurante para o e-mail passado")));
    }

    
}