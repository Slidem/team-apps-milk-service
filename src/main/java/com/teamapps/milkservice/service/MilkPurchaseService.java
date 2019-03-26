package com.teamapps.milkservice.service;

import com.teamapps.milkservice.objects.*;

import java.util.List;
import java.util.Map;

/**
 * @author Mihai Alexandru
 * @date 22.12.2018
 */
public interface MilkPurchaseService {

    PageResult<Map<User, List<MilkPurchase>>, MilkPurchaseSearchCriteria> getUsersMilkPurchases(MilkPurchaseSearchCriteria searchCriteria);

    void deleteMilkPurchase(Integer id, Context context);

    MilkPurchase purchase(Integer bottles, Integer bottleQuantityInMg, Context context);

}
