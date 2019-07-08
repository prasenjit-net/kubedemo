package net.prasenjit.demo.kubeapp.controller;

import net.prasenjit.demo.kubeapp.model.ApiMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    @GetMapping("/")
    public ApiMessage message(@RequestParam(defaultValue = "World") String name) {
        return new ApiMessage("Hello " + name + "! from " + ip);
    }
}
