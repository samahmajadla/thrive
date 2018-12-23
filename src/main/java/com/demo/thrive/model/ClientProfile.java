package com.demo.thrive.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ClientProfile")
public class ClientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name="client_id", updatable = false, nullable = false)
    private Long clientId;

    @Column(name = "heightFeet", updatable = false)
    private Long heightFeet;

    @Column(name = "heightInches", updatable = false)
    private Long heightInches;

    @Column(name = "weight")
    private Long weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "membership")
    private MembershipType membership;


    @OneToMany(mappedBy = "clientProfile")
    private List<Goal> goals = new ArrayList<Goal>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getHeightFeet() {
        return heightFeet;
    }

    public void setHeightFeet(Long heightFeet) {
        this.heightFeet = heightFeet;
    }

    public Long getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(Long heightInches) {
        this.heightInches = heightInches;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public MembershipType getMembership() {
        return membership;
    }

    public void setMembership(MembershipType membership) {
        this.membership = membership;
    }
}
