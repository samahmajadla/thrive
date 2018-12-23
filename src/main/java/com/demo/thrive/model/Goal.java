package com.demo.thrive.model;

import javax.persistence.*;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    private OnlineClientProfile onlineClientProfile;

    @Column(name = "foal", nullable = false)
    private String goal;
}
