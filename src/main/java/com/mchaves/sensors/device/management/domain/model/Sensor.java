package com.mchaves.sensors.device.management.domain.model;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Sensor implements Serializable {

    private TSID id;
    private String name;
    private String ip;
    private String location;
    private String protocol;
    private String model;
    private Boolean enable;
}
