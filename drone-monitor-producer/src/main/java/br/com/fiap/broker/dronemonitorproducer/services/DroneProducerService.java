package br.com.fiap.broker.dronemonitorproducer.services;

import br.com.fiap.broker.dronemonitorproducer.vo.DroneVO;

public interface DroneProducerService {

    void registerDrone(final DroneVO drone) throws Exception;
}
