package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Sensor implements Serializable {

    @Id
    String sensorName;

    private String info;

    @ManyToOne
    @JsonIgnore //양방향 순환참조
    @Id
    private Floor floor;

    // 온도
    boolean useTemperature;

    // 습도
    boolean useHumidity;

    // 미세먼지
    boolean useFinedust;

    // 이산화탄소
    boolean useCarbondioxide;

    // 포름알데히드
    boolean useFormaldehyde;


}
