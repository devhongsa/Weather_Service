package com.zbhong.weather.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String weather;

    @Column(length = 50)
    private String icon;

    private double temperature;

    @Column(length = 500)
    private String text;

    private LocalDate date;
}
