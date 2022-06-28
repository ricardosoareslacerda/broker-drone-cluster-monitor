package br.com.fiap.broker.dronemonitorconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.fiap.broker.dronemonitorconsumer.config",
		"br.com.fiap.broker.dronemonitorconsumer.business",
		"br.com.fiap.broker.dronemonitorconsumer.consumer",
		"br.com.fiap.broker.dronemonitorconsumer.service",
		"br.com.fiap.broker.dronemonitorconsumer.vo"})
@EnableAutoConfiguration
public class DroneMonitorConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneMonitorConsumerApplication.class, args);
	}

}

