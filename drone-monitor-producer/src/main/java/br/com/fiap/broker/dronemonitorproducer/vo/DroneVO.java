package br.com.fiap.broker.dronemonitorproducer.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class DroneVO {
    private int id;
    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal temperature;
    private BigDecimal humidity;

    public String toString() {
        return "DroneVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}