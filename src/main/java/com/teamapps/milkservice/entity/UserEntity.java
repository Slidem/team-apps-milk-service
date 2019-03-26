package com.teamapps.milkservice.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

/**
 * @author Mihai Alexandru
 * @date 24.11.2018
 */
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String login;

    private String firstName;

    private String lastName;

    private String password;

    @Column(unique = true)
    private String email;

    @Lob
    @Column(columnDefinition = "bytea")
    private byte[] picture;

    private String roles;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MilkPurchaseEntity> milkPurchases;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<MilkPurchaseEntity> getMilkPurchases() {
        return milkPurchases;
    }

    public void setMilkPurchases(List<MilkPurchaseEntity> milkPurchases) {
        if (Objects.isNull(milkPurchases)) {
            return;
        }
        milkPurchases.forEach(mp -> mp.setUser(this));
        this.milkPurchases = milkPurchases;
    }

    public void addMilkPurchase(MilkPurchaseEntity milkPurchase) {
        requireNonNull(milkPurchase);
        if (isNull(milkPurchases)) {
            milkPurchases = new ArrayList<>();
        }
        milkPurchase.setUser(this);
        milkPurchases.add(milkPurchase);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(id, userEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
