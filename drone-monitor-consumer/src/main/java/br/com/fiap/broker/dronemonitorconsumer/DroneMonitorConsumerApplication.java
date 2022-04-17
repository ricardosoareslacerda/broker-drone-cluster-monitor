package br.com.fiap.broker.dronemonitorconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class DroneMonitorConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneMonitorConsumerApplication.class, args);
	}

}
