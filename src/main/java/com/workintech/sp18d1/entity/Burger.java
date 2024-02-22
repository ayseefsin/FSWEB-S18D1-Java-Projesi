package com.workintech.sp18d1.entity;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="burger", schema="public")
@AllArgsConstructor
@NoArgsConstructor
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name" , nullable = false)
    private  String name;
    @Column(name = "price" ,nullable = false)
    private Double price;
    @Column(name = "is_vegan")
    private Boolean isVegan;

    @Enumerated(EnumType.STRING)
    private BreadType breadType;
    @Column(name = "contents")
    private String contents;

}
