package br.com.fiap.broker.dronemonitorproducer.rest;

import br.com.fiap.broker.dronemonitorproducer.services.DroneProducerService;
import br.com.fiap.broker.dronemonitorproducer.vo.DroneVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/drones")
public class ControllerApiImpl implements Api {

    private final DroneProducerService droneProducerService;

    @PutMapping(value = "register/{droneId}")
    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public void registerDrone(@PathVariable final String droneId, @RequestBody final DroneVO drone) {
        try {
            log.info("Registering drone with id {}", droneId);
            this.droneProducerService.registerDrone(drone);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
