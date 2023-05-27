package com.zbhong.weather.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Weather {
    @Id
    private LocalDate date;

    @Column(length = 50)
    private String weather;

    @Column(length = 50)
    private String icon;

    private double temperature;

}
