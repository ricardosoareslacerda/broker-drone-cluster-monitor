package br.com.fiap.broker.dronemonitorproducer.business;

import br.com.fiap.broker.dronemonitorproducer.vo.DroneVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DroneBusiness {

    public void verifyDrone(final DroneVO droneVO) {
        if (!droneVO.isRastreability()) {

            log.error("Drone {} is not rastreability!", droneVO);
        }
    }
}
