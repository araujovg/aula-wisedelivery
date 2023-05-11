package br.com.gva.wisedelivery.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ImageServiceImpl {

    @Value("${app.upload.endereco.diretorio}")
    private String diretorioDeUpload;

    public String uploadImagem(MultipartFile bytesDaImagem) {
        StringBuilder buildNomeArquivo = new StringBuilder();
        Path nomeArquivoECaminho = Paths.get(diretorioDeUpload, bytesDaImagem.getOriginalFilename());
        try {
            Files.write(nomeArquivoECaminho, bytesDaImagem.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
            log.info("Sucesso ao salvar a imagem!!!");
        } catch (IOException e) {
            try {
                log.error("Erro ao tentar sobrescrever a imagem. Criando a imagem: " + e.getMessage());
                Files.write(nomeArquivoECaminho, bytesDaImagem.getBytes());
            } catch (IOException e1) {
                log.error("Erro ao salvar a imagem: " + e1.getMessage());
            }
        }
        
        return buildNomeArquivo.toString();
    }
    
}