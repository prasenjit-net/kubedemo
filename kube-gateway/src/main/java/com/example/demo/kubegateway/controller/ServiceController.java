package com.example.demo.kubegateway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ServiceController {

    private final DiscoveryClient discoveryClient;

    @GetMapping("services")
    public List<String> services(){
        return discoveryClient.getServices();
    }
}
