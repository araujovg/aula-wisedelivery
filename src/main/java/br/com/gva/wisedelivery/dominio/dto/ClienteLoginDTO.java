package br.com.gva.wisedelivery.dominio.dto;

import lombok.Data;

@Data
public class ClienteLoginDTO {

    private String email;
    private String senha;

}