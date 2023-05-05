package br.com.gva.wisedelivery.exception;

public class SenhaInvalidaException extends RuntimeException{
    
    public SenhaInvalidaException(String msg) {
        super(msg);
    }
}