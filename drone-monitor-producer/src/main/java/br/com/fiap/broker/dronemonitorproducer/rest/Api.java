package br.com.fiap.broker.dronemonitorproducer.rest;

import br.com.fiap.broker.dronemonitorproducer.vo.DroneVO;

public interface Api {

    void registerDrone(final String droneId, final DroneVO drone);
}
