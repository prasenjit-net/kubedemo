package com.example.demo.kubegateway;

import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.ServiceType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@KubernetesApplication(serviceType = ServiceType.LoadBalancer, group = "identityorg")
public class KubeGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(KubeGatewayApplication.class, args);
    }

}
