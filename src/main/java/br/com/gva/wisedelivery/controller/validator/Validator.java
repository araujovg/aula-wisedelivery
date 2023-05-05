package br.com.gva.wisedelivery.controller.validator;

public interface Validator<T> {
    
    boolean validator(T t);
}