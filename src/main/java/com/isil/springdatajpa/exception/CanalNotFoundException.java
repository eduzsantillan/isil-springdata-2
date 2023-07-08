package com.isil.springdatajpa.exception;

public class CanalNotFoundException extends RuntimeException{
    public CanalNotFoundException(){
        super("Canal no ingresado");
    }
}
