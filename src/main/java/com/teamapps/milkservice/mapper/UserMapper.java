package com.teamapps.milkservice.mapper;

import com.teamapps.milkservice.entity.MilkPurchaseEntity;
import com.teamapps.milkservice.entity.UserEntity;
import com.teamapps.milkservice.objects.User;

import static com.teamapps.milkservice.objects.User.UserBuilder.anUser;

/**
 * @author Mihai Alexandru
 * @date 23.12.2018
 */
public class UserMapper {

    public static User fromEntity(UserEntity userEntity) {
        return anUser()
                .withId(userEntity.getId())
                .withLogin(userEntity.getLogin())
                .withEmail(userEntity.getEmail())
                .withFirstName(userEntity.getFirstName())
                .withLastName(userEntity.getLastName())
                .withPicture(userEntity.getPicture())
                .withRoles(userEntity.getRoles())
                .build();
    }

    public static User fromPurchaseEntity(MilkPurchaseEntity milkPurchaseEntity) {
        return fromEntity(milkPurchaseEntity.getUser());
    }

}
