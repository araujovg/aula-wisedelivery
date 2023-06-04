package br.com.gva.wisedelivery;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gva.wisedelivery.dominio.entidades.cliente.Cliente;
import br.com.gva.wisedelivery.dominio.entidades.restaurante.CategoriaItem;
import br.com.gva.wisedelivery.dominio.entidades.restaurante.ItemCardapio;
import br.com.gva.wisedelivery.dominio.entidades.restaurante.Restaurante;
import br.com.gva.wisedelivery.dominio.entidades.restaurante.RestauranteCategoria;
import br.com.gva.wisedelivery.repository.CategoriaItemRepository;
import br.com.gva.wisedelivery.repository.ClienteRepository;
import br.com.gva.wisedelivery.repository.ItemCardapioRepository;
import br.com.gva.wisedelivery.repository.RestauranteCategoriaRepository;
import br.com.gva.wisedelivery.repository.RestauranteRepository;
import br.com.gva.wisedelivery.utils.ServiceUtils;

@SpringBootApplication
public class WisedeliveryApplication implements CommandLineRunner{

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private RestauranteCategoriaRepository restauranteCategoriaRepository;

	@Autowired
	private CategoriaItemRepository categoriaItemRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private ItemCardapioRepository itemCardapioRepository;

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
			.nome("Mediterraneo")
			.imagem("null")
			.build();

		restauranteCategoriaRepository.saveAll(List.of(cat1, cat2, cat3, cat4));

		utils.consultaCep("28908090");

		var catItem1 = CategoriaItem.builder()
			.nome("Bebidas")
			.imagem("null")
			.build();

		var catItem2 = CategoriaItem.builder()
			.nome("Refeicao")
			.imagem("null")
			.build();

		var catItem3 = CategoriaItem.builder()
			.nome("Sobremesas")
			.imagem("null")
			.build();

		var catItem4 = CategoriaItem.builder()
			.nome("Lanches")
			.imagem("null")
			.build();

		categoriaItemRepository.saveAll(List.of(catItem1, catItem2, catItem3, catItem4));

		Restaurante rest = new Restaurante();
		rest.setNome("Office Cafe");
		rest.setEmail("teste@teste.com");
		rest.setCnpj("111111111111");
		rest.setTelefone("21999999999");
		rest.setSenha("1234");
		rest.setTaxaEntrega(BigDecimal.valueOf(10.0));
		rest.setCategorias(Set.of(cat1, cat2));

		Restaurante rest2 = new Restaurante();
		rest2.setNome("Tia Maluca");
		rest2.setEmail("tiamaluca@teste.com");
		rest2.setCnpj("111111111111");
		rest2.setTelefone("21999999999");
		rest2.setSenha("1234");
		rest.setTaxaEntrega(BigDecimal.valueOf(5.0));
		rest2.setCategorias(Set.of(cat3, cat4));

		Cliente cli1 = new Cliente();
		cli1.setNome("Cliente Teste");
		cli1.setCpf("11111111111");
		cli1.setEmail("cliente@teste.com");
		cli1.setSenha("1234");
		cli1.setTelefone("21999999999");

		clienteRepository.save(cli1);

		restauranteRepository.saveAll(List.of(rest, rest2));

		criarESalvarItensDeCardapio(rest, List.of(catItem1, catItem2));
		criarESalvarItensDeCardapio(rest2, List.of(catItem3, catItem4));
	}

	private void criarESalvarItensDeCardapio(Restaurante restaurante, List<CategoriaItem> categorias){
		var item1 = ItemCardapio.builder()
						.nome("Batata Maluca")
						.descricao("Batata frita com muita cebola e calabresa")
						.preco(BigDecimal.valueOf(25.0))
						.destaque(Boolean.TRUE)
						.ativo(Boolean.TRUE)
						.restaurante(restaurante)
						.categorias(categorias)
						.build();

		var item2 = ItemCardapio.builder()
						.nome("Duplo X Burguer")
						.descricao("Hamburguer com 2 carnes e molho especial da casa")
						.preco(BigDecimal.valueOf(20.0))
						.destaque(Boolean.TRUE)
						.ativo(Boolean.TRUE)
						.restaurante(restaurante)
						.categorias(categorias)
						.build();

		var item3 = ItemCardapio.builder()
						.nome("Dogão podrão")
						.descricao("Dogão gigante com tudo que tem direito")
						.preco(BigDecimal.valueOf(30.0))
						.destaque(Boolean.FALSE)
						.ativo(Boolean.TRUE)
						.restaurante(restaurante)
						.categorias(categorias)
						.build();

		var item4 = ItemCardapio.builder()
						.nome("Salgado Frito")
						.descricao("Variedades de Salgado Frito na hora")
						.preco(BigDecimal.valueOf(7.0))
						.destaque(Boolean.FALSE)
						.ativo(Boolean.FALSE)
						.restaurante(restaurante)
						.categorias(categorias)
						.build();

		var item5 = ItemCardapio.builder()
						.nome("Salgado Frito e Assado")
						.descricao("Variedades de Salgado Frito na hora")
						.preco(BigDecimal.valueOf(8.0))
						.destaque(Boolean.TRUE)
						.ativo(Boolean.TRUE)
						.restaurante(restaurante)
						.categorias(categorias)
						.build();

		var item6 = ItemCardapio.builder()
						.nome("Salgado Frito e Assado")
						.descricao("Variedades de Salgado Frito na hora")
						.preco(BigDecimal.valueOf(8.0))
						.destaque(Boolean.TRUE)
						.ativo(Boolean.TRUE)
						.restaurante(restaurante)
						.categorias(categorias)
						.build();

		itemCardapioRepository.saveAll(List.of(item1, item2, item3, item4, item5, item6));
	}

}
