package com.teamapps.milkservice.repository.specification;

import com.teamapps.milkservice.entity.MilkPurchaseEntity;
import com.teamapps.milkservice.objects.MilkPurchaseSearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;

/**
 * @author Mihai Alexandru
 * @date 22.12.2018
 */
public class MilkPurchaseSpecification implements Specification<MilkPurchaseEntity> {

    private MilkPurchaseSearchCriteria searchCriteria;

    public MilkPurchaseSpecification(MilkPurchaseSearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<MilkPurchaseEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate purchaseDatePredicate = criteriaBuilder.between(root.get("purchaseDate"), Date.from(searchCriteria.getFrom()), Date.from(searchCriteria.getTo()));
        Predicate validPurchases = criteriaBuilder.equal(root.get("status"), "VALID");
        return criteriaBuilder.and(purchaseDatePredicate, validPurchases);
    }
}
