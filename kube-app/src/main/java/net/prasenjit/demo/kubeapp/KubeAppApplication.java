package net.prasenjit.demo.kubeapp;

import io.dekorate.kubernetes.annotation.ImagePullPolicy;
import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.Port;
import io.dekorate.kubernetes.annotation.Probe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@KubernetesApplication(
        group = "identityorg", expose = true,
        ports = @Port(name = "http", containerPort = 8080),
        livenessProbe = @Probe(httpActionPath = "/actuator/health"),
        readinessProbe = @Probe(httpActionPath = "/actuator/health"),
        imagePullPolicy = ImagePullPolicy.Always,
        replicas = 3
)
public class KubeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(KubeAppApplication.class, args);
    }

}
