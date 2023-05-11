package br.com.gva.wisedelivery.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.gva.wisedelivery.dominio.dto.enderecodto.EnderecoDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ServiceUtils {

    @Getter @Setter
    @Value("${brasil.api.v2.cep.url}")
    private String apiUrl;
    //https://brasilapi.com.br/api/cep/v2/

    public void consultaCep(String cep){
        setApiUrl(apiUrl + cep);
        log.info("APIURL: " + getApiUrl());
        //https://brasilapi.com.br/api/cep/v2/28908090

        RestTemplate rt = new RestTemplate();
        ResponseEntity<EnderecoDTO> result = rt.getForEntity(getApiUrl(), EnderecoDTO.class);

        log.info("RESULTADO: " + result.getBody());
    }
    
}