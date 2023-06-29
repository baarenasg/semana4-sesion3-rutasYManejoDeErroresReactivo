package com.santiago.posada.service;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    private String helloWorld = "Hello Bancolombia's team";

    public String saludar(){
        return helloWorld;
    }
}
