package br.com.gva.wisedelivery.dominio.dto.enderecodto;

import lombok.Data;

@Data
public class EnderecoDTO {
   private String cep;
   private String estado;
   private String cidade;
   private String bairro;
   private String rua;
   private String numero;

}