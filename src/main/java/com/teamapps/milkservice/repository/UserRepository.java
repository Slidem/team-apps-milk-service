package com.teamapps.milkservice.repository;

import com.teamapps.milkservice.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Mihai Alexandru
 * @date 23.12.2018
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    Optional<UserEntity> getUserEntitiesByLogin(String login);

}
