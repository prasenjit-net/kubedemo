package net.prasenjit.demo.kubeapp.controller;

import lombok.extern.slf4j.Slf4j;
import net.prasenjit.demo.kubeapp.model.ApiMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApiController {

    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/greeting")
    public ApiMessage message(@RequestParam(defaultValue = "World") String name) {
        log.info("KUBE-APP called with name=" + name);
        return new ApiMessage("Hello " + name + "! from " + ip, discoveryClient.getServices());
    }
}
