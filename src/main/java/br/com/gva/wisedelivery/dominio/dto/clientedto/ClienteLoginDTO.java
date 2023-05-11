package br.com.gva.wisedelivery.dominio.dto.clientedto;

import lombok.Data;

@Data
public class ClienteLoginDTO {

    private String email;
    private String senha;

}