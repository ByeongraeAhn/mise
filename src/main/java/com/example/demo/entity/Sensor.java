package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
    String name;

    private String info;

    @ManyToOne
    @JsonIgnore //양방향 순환참조 제거
    @Id
    //@JoinColumn(name = "floor_id", referencedColumnName = "id")
    private Floor floor;

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Builder.Default
    private List<SensingHistory> sensingHistorys = new ArrayList<>();

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
