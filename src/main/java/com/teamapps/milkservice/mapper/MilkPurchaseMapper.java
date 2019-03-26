package com.teamapps.milkservice.mapper;

import com.teamapps.milkservice.entity.MilkPurchaseEntity;
import com.teamapps.milkservice.objects.MilkPurchase;

import static com.teamapps.milkservice.objects.MilkPurchase.MilkPurchaseBuilder.aMilkPurchase;

/**
 * @author Mihai Alexandru
 * @date 23.12.2018
 */
public class MilkPurchaseMapper {

    public static MilkPurchase fromEntity(MilkPurchaseEntity milkPurchaseEntity) {
        return aMilkPurchase()
                .withId(milkPurchaseEntity.getId())
                .withBottleQuantity(milkPurchaseEntity.getBottleQuantity())
                .withBottles(milkPurchaseEntity.getBottles())
                .withPurchaseDate(milkPurchaseEntity.getPurchaseDate().toInstant())
                .withStatus(milkPurchaseEntity.getStatus())
                .build();
    }

}
