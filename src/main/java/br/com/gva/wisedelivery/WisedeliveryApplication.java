package br.com.gva.wisedelivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gva.wisedelivery.dominio.RestauranteCategoria;
import br.com.gva.wisedelivery.repository.RestauranteCategoriaRepository;
import br.com.gva.wisedelivery.utils.ServiceUtils;

@SpringBootApplication
public class WisedeliveryApplication implements CommandLineRunner{

	@Autowired
	private RestauranteCategoriaRepository restauranteCategoriaRepository;

	@Autowired
	private ServiceUtils utils;

	public static void main(String[] args) {
		SpringApplication.run(WisedeliveryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		var cat1 = RestauranteCategoria.builder()
			.nome("Churrasco")
			.imagem("null")
			.build();

		var cat2 = RestauranteCategoria.builder()
			.nome("Massas")
			.imagem("null")
			.build();
		
		var cat3 = RestauranteCategoria.builder()
			.nome("Asiática")
			.imagem("null")
			.build();

		var cat4 = RestauranteCategoria.builder()
			.nome("Lanches")
			.imagem("null")
			.build();

		restauranteCategoriaRepository.saveAll(List.of(cat1, cat2, cat3, cat4));

		utils.consultaCep("28908090");

	}

}
