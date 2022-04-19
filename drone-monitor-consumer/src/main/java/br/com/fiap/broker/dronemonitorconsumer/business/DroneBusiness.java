package br.com.fiap.broker.dronemonitorconsumer.business;

import br.com.fiap.broker.dronemonitorconsumer.service.MailService;
import br.com.fiap.broker.dronemonitorconsumer.vo.DroneVO;
import br.com.fiap.broker.dronemonitorconsumer.vo.MailVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class DroneBusiness {

    private Map<String, List<LocalTime>> mapDronesTimes;

    private final MailService mailService;

    @Value("${mail.sender.fromAddress}")
    private String fromAddress;

    @Value("${mail.sender.toAddresses}")
    private String toAddresses;

    @Value("${mail.sender.subject}")
    private String subject;

    private void setMapDronesTimes(String droneId) {
        if (mapDronesTimes == null) {
            mapDronesTimes = new HashMap<>();
            mapDronesTimes.put(droneId, new ArrayList<LocalTime>(Collections.singleton(LocalTime.now())));
        }
        else {
            if (mapDronesTimes.containsKey(droneId)) {
                mapDronesTimes.get(droneId).add(LocalTime.now());
            } else {
                mapDronesTimes.put(droneId, new ArrayList<LocalTime>(Collections.singleton(LocalTime.now())));
            }
        }
    }

    public void verifyDrone(final DroneVO droneVO) {
        this.setMapDronesTimes(droneVO.getId());

        boolean isInValidTemperature = ((Long.valueOf(droneVO.getTemperature()).compareTo(35L) >= 0)
                                            || (Long.valueOf(droneVO.getTemperature()).compareTo(0L) <= 0));
        boolean isInValidHumidity = (Long.valueOf(droneVO.getHumidity()).compareTo(15L) <= 0);
        if (isInValidTemperature || isInValidHumidity) {

            log.warn("Drone " + droneVO.getId() + " is down");

            try {
                mailService.sendMail(MailVO.builder()
                            .fromAddress(fromAddress)
                            .toAddresses(toAddresses)
                            .subject(subject)
                            .drone(droneVO)
                            .build());
            }
            catch (Exception e) {
                log.error("Error sending mail", e);
            }
        }

        // regra de 1 minuto
        /*final List<LocalTime> localTimes = mapDronesTimes.get(droneVO.getId());
        if (localTimes.size() > 1) {
            final LocalTime minLocalTime = localTimes.stream().min(Comparator.comparing(time -> time.toNanoOfDay())).get();
            final LocalTime maxLocalTime = localTimes.stream().max(Comparator.comparing(time -> time.toNanoOfDay())).get();
            if (maxLocalTime.minusSeconds(60L).equals(minLocalTime)) {
                if ((droneVO.getTemperature().compareTo(BigDecimal.valueOf(35.0)) >= 0)
                        || (droneVO.getTemperature().compareTo(BigDecimal.valueOf(0.0)) <= 0)) {
                    log.warn("Drone " + droneVO.getId() + " is down");

                    mailService.sendMail(MailVO.builder().from("ricardosoareslacerda@gmail.com").subject("Alert Drones is downing").to("ricardosoareslacerda@gmail.com").build());
                }
            }
        }*/
    }
}
