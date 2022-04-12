package br.com.fiap.broker.dronemonitorproducer.services;

import br.com.fiap.broker.dronemonitorproducer.vo.DroneVO;

public interface DroneService {

    void registerDrone(final DroneVO drone) throws Exception;

    void executeSampleJob();
}
