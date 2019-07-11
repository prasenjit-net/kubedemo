package net.prasenjit.demo.kubeapp.model;

import lombok.Data;

import java.util.List;

@Data
public class ApiMessage {
    private final String message;
    private final List<String> services;
}
