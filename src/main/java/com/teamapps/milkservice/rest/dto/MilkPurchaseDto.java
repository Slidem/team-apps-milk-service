package com.teamapps.milkservice.rest.dto;

import com.teamapps.milkservice.rest.annotation.Id;

import java.time.Instant;

/**
 * @author Mihai Alexandru
 * @date 24.12.2018
 */
public class MilkPurchaseDto {

    @Id
    public Integer id;

    public Integer bottles;

    public Integer bottleQuantity;

    public Instant purchaseDate;
}
