package br.com.fiap.broke.dronemonitorjob.job;

import br.com.fiap.broke.dronemonitorjob.parser.JsonCustomParser;
import br.com.fiap.broke.dronemonitorjob.vo.DroneVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

@Slf4j
@Component
public class ScheduledDroneTasks {

    @Value("${drone.api.host.path}")
    private String hostPath;

    @Value("${drone.api.host.resource}")
    private String hostResource;

    @Value("#{${listOfDrones}}")
    private Map<String, String> listOfDrones;

    private RestTemplate restTemplate = new RestTemplate();

    @Scheduled(cron = "${dronemonitor.job.cron-scheduler}")
    public void registerDrones() {

        listOfDrones.forEach((droneId, droneName) -> {
            log.info("Registering Drone: {}: {}", droneId, droneName);
            final DroneVO droneVO = this.getDroneVO(droneId, droneName);

            log.info("DroneVO: {}", JsonCustomParser.parseObjectToJson(DroneVO.class, droneVO));
            log.info("The time of register drone {}", new SimpleDateFormat("HH:mm:ss").format(new Date()));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            restTemplate.exchange(hostPath.concat(hostResource).concat(droneVO.getId()), HttpMethod.PUT, new HttpEntity<DroneVO>(droneVO, headers), String.class);
        });
    }

    private DroneVO getDroneVO(final String droneId, final String droneName) {
        DroneVO droneVO = DroneVO.builder().
                                        id(droneId).
                                        name(droneName).
                                        latitude(-23.5F).
                                        longitude(-46.6F).
                                        humidity(new BigDecimal(Math.random() * 100)).
                                        temperature(new BigDecimal(Math.random() * 100)).
                                        rastreability(true).
                                        lastUpdate(LocalDateTime.now().atZone(ZoneId.of("America/Sao_Paulo")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"))).build();
        return droneVO;
    }
}
