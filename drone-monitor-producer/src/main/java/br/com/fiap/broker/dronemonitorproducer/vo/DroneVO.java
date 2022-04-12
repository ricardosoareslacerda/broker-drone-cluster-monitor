package br.com.fiap.broker.dronemonitorproducer.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class DroneVO {
    private long droneId;
    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal temperature;
    private BigDecimal humidity;
    private boolean rastreability;
}
