package br.com.gva.wisedelivery.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.com.gva.wisedelivery.exception.PaymentException;
import br.com.gva.wisedelivery.integrations.DadosCartao;
import br.com.gva.wisedelivery.integrations.StatusPagamento;
import lombok.Getter;

@Service
public class PaymentService {

    @Value("${payment.pay.url}")
    private String payUrl;

    @Value("${payment.pay.token}")
    private String payToken;

    @Getter
    private HttpEntity<DadosCartao> requestEntity;

    @Getter
    private MultiValueMap<String, String> headers;
    
    @Getter
    private Map<String, String> response;

    @Getter
    private RestTemplate http;
    

    public String pay(DadosCartao dadosCartao){
        headers  = new LinkedMultiValueMap<>();        
        headers.add("Token", payToken);

        requestEntity = new HttpEntity<>(dadosCartao, headers);

        http = new RestTemplate();
        try {
            response = http.postForObject(payUrl, requestEntity, Map.class);
        } catch(Exception e) {
            throw new PaymentException("Erro no servidor de pagamento");
        }
        StatusPagamento status = StatusPagamento.valueOf(response.get("status"));

        if(!status.equals(status.AUTORIZADO)) {
            throw new PaymentException(status.getDescricao());
        }
        return status.getDescricao();
    }
    
}