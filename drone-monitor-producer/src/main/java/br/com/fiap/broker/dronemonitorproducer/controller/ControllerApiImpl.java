package br.com.fiap.broker.dronemonitorproducer.controller;

import br.com.fiap.broker.dronemonitorproducer.services.DroneProducerService;
import br.com.fiap.broker.dronemonitorproducer.vo.DroneVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/drones-monitor/drones")
public class ControllerApiImpl implements Api {

    private final DroneProducerService droneProducerService;

    @PutMapping(value = "register/{id}")
    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public void registerDrone(@PathVariable int id, @RequestBody final DroneVO drone) {
        try {
            this.droneProducerService.registerDrone(drone);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
