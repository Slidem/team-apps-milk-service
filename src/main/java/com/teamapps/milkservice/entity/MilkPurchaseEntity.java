package com.teamapps.milkservice.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Mihai Alexandru
 * @date 22.12.2018
 */
@Entity
@Table(name = "milk_purchases")
public class MilkPurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private Integer bottles;

    private Integer bottleQuantity;

    private Timestamp purchaseDate;

    private String status;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBottles() {
        return bottles;
    }

    public void setBottles(Integer bottles) {
        this.bottles = bottles;
    }

    public Integer getBottleQuantity() {
        return bottleQuantity;
    }

    public void setBottleQuantity(Integer bottleQuantity) {
        this.bottleQuantity = bottleQuantity;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
