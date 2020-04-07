package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//양방향 순환참조로 @Data 및 @ToString은 지양한다.
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Floor {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String info;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Builder.Default
    private List<Sensor> sensors = new ArrayList<>();

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
        sensor.setFloor(this);
    }
}

