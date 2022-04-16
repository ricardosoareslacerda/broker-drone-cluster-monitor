package br.com.fiap.broker.dronemonitorproducer.controller;

import br.com.fiap.broker.dronemonitorproducer.vo.DroneVO;
import org.springframework.web.bind.annotation.PathVariable;

public interface Api {

    void registerDrone(@PathVariable int id, final DroneVO drone);
}
