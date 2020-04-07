package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
public class SensingHistory implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String info;

    private Date date;

    @ManyToOne
    @JsonIgnore //양방향 순환참조 제거
    // @Id
    @JoinColumns({
        @JoinColumn(
            name = "floor_id",
            referencedColumnName = "floor_id"),
        @JoinColumn(
            name = "name",
            referencedColumnName = "name")
    })
    private Sensor sensor;

    // 온도
    String temperature;

    // 습도
    String humidity;

    // 미세먼지
    String finedust;

    // 이산화탄소
    String carbondioxide;

    // 포름알데히드
    String formaldehyde;


}
