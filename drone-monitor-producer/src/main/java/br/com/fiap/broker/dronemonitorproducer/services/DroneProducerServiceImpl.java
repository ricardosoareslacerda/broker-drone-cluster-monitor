package br.com.fiap.broker.dronemonitorproducer.services;

import br.com.fiap.broker.dronemonitorproducer.vo.DroneVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DroneProducerServiceImpl implements DroneProducerService {

    @Value("${topic.name.producer}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void registerDrone(final DroneVO dronevO) throws Exception {
        try {
            log.info("Sending drone to kafka: {}", dronevO);
            kafkaTemplate.send(topic, dronevO.toString());
        }
        catch (Exception e) {
            log.error("Error sending drone to kafka: {}", dronevO, e);
        }

        System.out.println("Registering drone: " + dronevO.getId());
    }
}
