package com.example.demo.kubegateway;

import io.dekorate.kubernetes.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@KubernetesApplication(
        serviceType = ServiceType.LoadBalancer,
        group = "identityorg", expose = true,
        ports = @Port(name = "http", containerPort = 9090),
        livenessProbe = @Probe(httpActionPath = "/actuator/health"),
        readinessProbe = @Probe(httpActionPath = "/actuator/health"),
        imagePullPolicy = ImagePullPolicy.Always
)
public class KubeGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(KubeGatewayApplication.class, args);
    }

}
