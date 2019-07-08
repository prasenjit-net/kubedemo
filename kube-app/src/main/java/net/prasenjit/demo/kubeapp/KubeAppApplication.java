package net.prasenjit.demo.kubeapp;

import io.dekorate.kubernetes.annotation.KubernetesApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@KubernetesApplication(group = "identityorg")
public class KubeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(KubeAppApplication.class, args);
    }

}
