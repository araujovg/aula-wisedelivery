package br.com.gva.wisedelivery.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

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

    public ServiceUtils() throws NoSuchAlgorithmException{}
    
    private Random random = SecureRandom.getInstanceStrong();

    @Getter @Setter
    @Value("${brasil.api.v2.cep.url}")
    private String apiUrl;

    public void consultaCep(String cep){
        setApiUrl(apiUrl + cep);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<EnderecoDTO> result = rt.getForEntity(getApiUrl(), EnderecoDTO.class);
    }
    
    public String getToken() {
        StringBuilder token = new StringBuilder();
            for(int i = 0; i < 150; i++) {
                char c = (char) (this.random.nextInt(26) + 'a');
                token.append(c);
            }
        return token.toString();
    }
}