package br.com.fiap.broker.dronemonitorconsumer.consumer;

import br.com.fiap.broker.dronemonitorconsumer.vo.DroneVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DroneConsumer {

    /*@KafkaListener(topics = "${topic.name.consumer}", groupId = "drone_group")
    public void consume(ConsumerRecord<String, DroneVO> payload) {
        log.info("Topico: {}", payload.topic());
        log.info("Key: {}", payload.key());
        log.info("Headers: {}", payload.headers());
        log.info("Partition: {}", payload.partition());
        log.info("Value: {}", payload.value());
    }*/

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${group.name.consumer}", containerFactory = "jsonKafkaListenerContainerFactory")
    public void consume(final DroneVO payload) {

        log.info("Value: {}", payload.toString());
    }
}