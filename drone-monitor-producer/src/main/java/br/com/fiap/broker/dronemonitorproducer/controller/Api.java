package br.com.fiap.broker.dronemonitorproducer.controller;

import br.com.fiap.broker.dronemonitorproducer.vo.DroneVO;

public interface Api {

    void registerDrone(final DroneVO drone);
}
