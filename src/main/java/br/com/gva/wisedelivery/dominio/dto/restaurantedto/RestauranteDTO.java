package br.com.gva.wisedelivery.dominio.dto.restaurantedto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import br.com.gva.wisedelivery.dominio.RestauranteCategoria;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RestauranteDTO {

    private Long id;

    @NotBlank(message = "Nome não pode estar vazio")
    @Size(max = 80)
    private String nome;

    @NotBlank(message = "Email não pode estar vazio")
    @Size(max = 60)
    @Email(message = "Formato de e-mail inválido")
    private String email;

    @NotBlank(message = "Senha não pode estar vazia")
    @Size(max = 80)
    private String senha;

    @NotBlank(message = "Confirmação de senha não pode estar vazia")
    @Size(max = 80)
    private String confirmaSenha;

    @NotBlank(message = "Telefone não pode estar vazio")
    @Size(max = 20)
    private String telefone;

    @NotBlank(message = "CNPJ não pode estar vazio")
    @Size(max = 14)
    @Pattern(regexp = "[0-9]{14}")
    private String cnpj;

    private MultipartFile arquivoLogotipo;

    private String logotipo;

    @NotNull(message = "Taxa de Entrega não pode ser 0")
    private BigDecimal taxaEntrega;

    @NotNull(message = "Tempo de Entrega não pode ser 0")
    private Integer tempoEntrega;

    
    private Set<RestauranteCategoria> categorias = new HashSet<>();
}