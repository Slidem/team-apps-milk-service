package com.teamapps.milkservice.rest.dto.mapper;

import com.teamapps.milkservice.objects.MilkPurchase;
import com.teamapps.milkservice.rest.dto.MilkPurchaseDto;

/**
 * @author Mihai Alexandru
 * @date 24.12.2018
 */
public class MilkPurchaseDtoMapper {

    public static MilkPurchaseDto toDto(MilkPurchase milkPurchase) {
        MilkPurchaseDto milkPurchaseDto = new MilkPurchaseDto();
        milkPurchaseDto.id = milkPurchase.getId();
        milkPurchaseDto.bottles = milkPurchase.getBottles();
        milkPurchaseDto.bottleQuantity = milkPurchase.getBottleQuantity();
        milkPurchaseDto.purchaseDate = milkPurchase.getPurchaseDate();
        return milkPurchaseDto;
    }

}
