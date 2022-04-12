package br.com.fiap.broker.dronemonitorproducer.repository;


import br.com.fiap.broker.dronemonitorproducer.entity.Drone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends MongoRepository<Drone, String> {

    Drone findByDroneId(long droneId);
}
