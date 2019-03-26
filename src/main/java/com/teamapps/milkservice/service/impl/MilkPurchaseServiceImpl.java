package com.teamapps.milkservice.service.impl;

import com.teamapps.milkservice.entity.MilkPurchaseEntity;
import com.teamapps.milkservice.entity.UserEntity;
import com.teamapps.milkservice.exception.NotFoundException;
import com.teamapps.milkservice.mapper.MilkPurchaseMapper;
import com.teamapps.milkservice.mapper.UserMapper;
import com.teamapps.milkservice.objects.*;
import com.teamapps.milkservice.repository.MilkPurchaseRepository;
import com.teamapps.milkservice.repository.UserRepository;
import com.teamapps.milkservice.repository.specification.MilkPurchaseSpecification;
import com.teamapps.milkservice.service.MilkPurchaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.teamapps.milkservice.objects.PageResult.PageResultBuilder.aPageResult;
import static java.time.Clock.systemUTC;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.*;
import static org.springframework.data.domain.Sort.Direction.ASC;

/**
 * @author Mihai Alexandru
 * @date 23.12.2018
 */
@Service
@Transactional
public class MilkPurchaseServiceImpl implements MilkPurchaseService {

    private MilkPurchaseRepository milkPurchaseRepository;

    private UserRepository userRepository;

    public MilkPurchaseServiceImpl(MilkPurchaseRepository milkPurchaseRepository, UserRepository userRepository) {
        this.milkPurchaseRepository = milkPurchaseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PageResult<Map<User, List<MilkPurchase>>, MilkPurchaseSearchCriteria> getUsersMilkPurchases(MilkPurchaseSearchCriteria searchCriteria) {
        Pageable pageable = PageRequest.of(searchCriteria.getPage(), searchCriteria.getLimit(), new Sort(ASC, "purchaseDate"));
        MilkPurchaseSpecification specification = new MilkPurchaseSpecification(searchCriteria);

        Page<MilkPurchaseEntity> purchases = milkPurchaseRepository.findAll(specification, pageable);

        Map<User, List<MilkPurchase>> data = mapMilkPurchases(purchases);
        addUsersWithNoPurchases(data);

        return aPageResult(data, searchCriteria)
                .withPageNumber(searchCriteria.getPage())
                .withPageSize(searchCriteria.getLimit())
                .withTotalElements(purchases.getTotalElements())
                .withTotalPages(purchases.getTotalPages())
                .build();
    }


    @Override
    public void deleteMilkPurchase(Integer id, Context context) {
        MilkPurchaseEntity milkPurchase = milkPurchaseRepository.findById(id).orElse(null);
        if (isNull(milkPurchase)) {
            throw new NotFoundException("No purchase found for id " + id);
        }
        milkPurchase.setStatus("DELETED");
        milkPurchaseRepository.save(milkPurchase);
    }

    @Override
    public MilkPurchase purchase(Integer bottles, Integer bottleQuantityInMg, Context context) {
        MilkPurchaseEntity milkPurchaseEntity = new MilkPurchaseEntity();
        milkPurchaseEntity.setBottles(bottles);
        milkPurchaseEntity.setBottleQuantity(bottleQuantityInMg);
        milkPurchaseEntity.setPurchaseDate(Timestamp.from(Instant.now(systemUTC())));
        milkPurchaseEntity.setStatus("VALID");

        Optional<UserEntity> userEntity = userRepository.findById(context.getUser().getId());
        if (!userEntity.isPresent()) {
            throw new NotFoundException("User not found");
        }

        UserEntity user = userEntity.get();
        user.addMilkPurchase(milkPurchaseEntity);
        milkPurchaseRepository.save(milkPurchaseEntity);
        return MilkPurchaseMapper.fromEntity(milkPurchaseEntity);
    }

    private Map<User, List<MilkPurchase>> mapMilkPurchases(Page<MilkPurchaseEntity> purchases) {
        return purchases.get().collect(groupingBy(UserMapper::fromPurchaseEntity, mapping(MilkPurchaseMapper::fromEntity, toList())));
    }

    private void addUsersWithNoPurchases(Map<User, List<MilkPurchase>> data) {
        Iterable<UserEntity> allUsers = userRepository.findAll();
        for (UserEntity userEntity : allUsers) {
            User user = UserMapper.fromEntity(userEntity);
            data.putIfAbsent(user, Collections.emptyList());
        }
    }
}
