package br.com.fiap.broker.dronemonitorproducer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@Document(collection = "drone_broker")
public class Drone {

    @MongoId(FieldType.STRING)
    @Field("id")
    @EqualsAndHashCode.Include
    private String id;

    @Field("idDdrone")
    @EqualsAndHashCode.Include
    private long droneId;

    @Field("name")
    @EqualsAndHashCode.Include
    private String name;

    @Field("latitude")
    private BigDecimal latitude;

    @Field("longitude")
    private BigDecimal longitude;

    @Field("temperature")
    private BigDecimal temperature;

    @Field("humidity")
    private BigDecimal humidity;

    @Field("rastreability")
    private boolean rastreability;
}
