package br.com.fiap.broker.dronemonitorproducer;

import br.com.fiap.broker.dronemonitorproducer.job.SchedulerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({ SchedulerConfig.class })
@SpringBootApplication
public class DroneMonitorProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneMonitorProducerApplication.class, args);
	}

}
