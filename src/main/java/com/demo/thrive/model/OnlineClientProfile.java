package com.demo.thrive.model;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "online_client")
public class OnlineClientProfile {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @OneToOne(targetEntity = Client.class)
    @JoinColumn(name="client_id", updatable = false, nullable = false)
    private Long clientId;

    @OneToMany(targetEntity = Goal.class)
    private List<Goal> goals = new ArrayList<Goal>();

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "packageLength")
    private Long packageLength;

    @Column(name = "heightFeet", updatable = false)
    private Long heightFeet;

    @Column(name = "heightInches", updatable = false)
    private Long heightInches;

    @Column(name = "weight")
    private Long weight;

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Long getPackageLength() {
        return packageLength;
    }

    public void setPackageLength(Long packageLength) {
        this.packageLength = packageLength;
    }

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


}
