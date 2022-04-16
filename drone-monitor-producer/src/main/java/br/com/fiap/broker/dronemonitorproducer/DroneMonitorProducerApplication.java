package br.com.fiap.broker.dronemonitorproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class DroneMonitorProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneMonitorProducerApplication.class, args);
	}

}
