package com.demo.thrive.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;


    @Column(name = "name", updatable = false, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany
    private List<Trainer> trainers;
}
