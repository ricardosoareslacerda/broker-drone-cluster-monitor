package br.com.fiap.broker.dronemonitorproducer.services;

import br.com.fiap.broker.dronemonitorproducer.entity.Drone;
import br.com.fiap.broker.dronemonitorproducer.repository.DroneRepository;
import br.com.fiap.broker.dronemonitorproducer.vo.DroneVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DroneServiceImpl implements DroneService {

    private static final Logger LOG = LoggerFactory.getLogger(DroneService.class);

    private DroneRepository droneRepository;
    private ObjectMapper objectmapper;
    @Override
    public void registerDrone(final DroneVO dronevO) throws Exception {

        Drone toPersisty = objectmapper.convertValue(dronevO, Drone.class);

        Drone droneSaved = droneRepository.findByDroneId(dronevO.getDroneId());
        if (droneSaved != null) {
            toPersisty = droneSaved.toBuilder().humidity(dronevO.getHumidity()).
                    latitude(dronevO.getLatitude()).
                    longitude(dronevO.getLongitude()).
                    temperature(dronevO.getTemperature()).
                    humidity(dronevO.getHumidity()).build();
        }

        System.out.println("Registering drone: " + dronevO.getDroneId());
        droneRepository.save(toPersisty);
    }

    @Override
    public void executeSampleJob() {
        System.out.println("Executing sample job -> Hello World!");
    }
}
