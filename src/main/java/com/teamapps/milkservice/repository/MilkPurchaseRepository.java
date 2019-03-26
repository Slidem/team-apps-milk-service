package com.teamapps.milkservice.repository;

import com.teamapps.milkservice.entity.MilkPurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Mihai Alexandru
 * @date 22.12.2018
 */
@Repository
public interface MilkPurchaseRepository extends JpaRepository<MilkPurchaseEntity, Integer>, JpaSpecificationExecutor<MilkPurchaseEntity> {


}
