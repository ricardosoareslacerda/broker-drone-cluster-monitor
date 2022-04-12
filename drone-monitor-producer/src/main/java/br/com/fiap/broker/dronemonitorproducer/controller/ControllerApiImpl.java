package br.com.fiap.broker.dronemonitorproducer.controller;

import br.com.fiap.broker.dronemonitorproducer.services.DroneService;
import br.com.fiap.broker.dronemonitorproducer.vo.DroneVO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ControllerApiImpl implements Api {

    private DroneService droneService;

    @PutMapping("register")
    @Override
    public void registerDrone(final DroneVO drone) {
        try {
            this.droneService.registerDrone(drone);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
