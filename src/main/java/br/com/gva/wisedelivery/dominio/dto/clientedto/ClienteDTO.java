package br.com.gva.wisedelivery.dominio.dto.clientedto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteDTO {

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
    @Pattern(regexp = "[0-9]")
    private String telefone;

    @NotBlank(message = "CPF não pode estar vazio")
    @Size(max = 11)
    @Pattern(regexp = "[0-9]{11}")
    private String cpf;
    
}