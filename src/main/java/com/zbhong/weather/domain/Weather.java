package com.zbhong.weather.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
