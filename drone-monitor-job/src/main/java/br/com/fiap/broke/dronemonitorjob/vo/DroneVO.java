package br.com.fiap.broke.dronemonitorjob.vo;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class DroneVO {

    private String id;
    private String name;
    private Float latitude;
    private Float longitude;
    private BigDecimal temperature;
    private BigDecimal humidity;
    private boolean rastreability;
    private String lastUpdate;
}