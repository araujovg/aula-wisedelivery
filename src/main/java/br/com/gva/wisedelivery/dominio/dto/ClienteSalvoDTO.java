package br.com.gva.wisedelivery.dominio.dto;

import lombok.Data;

@Data
public class ClienteSalvoDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

}