package com.teamapps.milkservice.rest.dto.mapper;

import com.teamapps.milkservice.objects.MilkPurchase;
import com.teamapps.milkservice.objects.User;
import com.teamapps.milkservice.rest.dto.UserPurchaseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mihai Alexandru
 * @date 24.12.2018
 */
public class UserMilkPurchasesDtoMapper {

    public static List<UserPurchaseDto> toDto(Map<User, List<MilkPurchase>> userPurchases) {
        List<UserPurchaseDto> purchaseDtos = new ArrayList<>();
        userPurchases.forEach((u, p) -> {
            UserPurchaseDto userPurchaseDto = new UserPurchaseDto();
            userPurchaseDto.user = UserDtoMapper.toDto(u);
            userPurchaseDto.milkPurchases = p.stream().map(MilkPurchaseDtoMapper::toDto).collect(Collectors.toList());
            purchaseDtos.add(userPurchaseDto);
        });
        return purchaseDtos;
    }
}
