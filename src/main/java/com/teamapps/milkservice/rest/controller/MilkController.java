package com.teamapps.milkservice.rest.controller;

import com.teamapps.milkservice.objects.Context;
import com.teamapps.milkservice.objects.MilkPurchase;
import com.teamapps.milkservice.objects.MilkPurchaseSearchCriteria;
import com.teamapps.milkservice.rest.annotation.Id;
import com.teamapps.milkservice.rest.dto.MilkPurchaseDto;
import com.teamapps.milkservice.rest.dto.MilkPurchaseRequestDto;
import com.teamapps.milkservice.rest.dto.UserPurchaseDto;
import com.teamapps.milkservice.rest.dto.mapper.MilkPurchaseDtoMapper;
import com.teamapps.milkservice.rest.dto.mapper.UserMilkPurchasesDtoMapper;
import com.teamapps.milkservice.rest.object.FindPurchases;
import com.teamapps.milkservice.service.MilkPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

import static com.teamapps.milkservice.objects.MilkPurchaseSearchCriteria.MilkPurchaseSearchCriteriaBuilder.aMilkPurchaseSearchCriteria;
import static com.teamapps.milkservice.rest.object.FindPurchases.FindPurchasesBuilder.aFindPurchases;
import static java.util.Optional.ofNullable;

/**
 * @author Mihai Alexandru
 * @date 24.12.2018
 */
@RestController
public class MilkController {

    private MilkPurchaseService milkPurchaseService;

    private Context context;

    @Autowired
    public MilkController(MilkPurchaseService milkPurchaseService, Context context) {
        this.milkPurchaseService = milkPurchaseService;
        this.context = context;
    }

    @PostMapping("/milk")
    MilkPurchaseDto purchase(@RequestBody MilkPurchaseRequestDto milkPurchaseRequestDto) {
        MilkPurchase purchase = milkPurchaseService.purchase(milkPurchaseRequestDto.bottles, milkPurchaseRequestDto.bottleQuantity, context);
        return MilkPurchaseDtoMapper.toDto(purchase);
    }

    @DeleteMapping("/milk/{purchaseId}")
    void removePurchase(@PathVariable @Id Integer purchaseId) {
        milkPurchaseService.deleteMilkPurchase(purchaseId, context);
    }

    @GetMapping("/milk/users")
    List<UserPurchaseDto> getUserPurchases(@ModelAttribute("findPurchases") FindPurchases findPurchases) {
        MilkPurchaseSearchCriteria searchCriteria = aMilkPurchaseSearchCriteria()
                .withFrom(findPurchases.getFrom())
                .withTo(findPurchases.getTo())
                .withLimit(findPurchases.getLimit())
                .withPage(findPurchases.getPage())
                .build();


        //TODO: does not return a page result... cannot be used for pagination.
        //TODO: add response with additional metadata and compute next page link / add pages information
        return UserMilkPurchasesDtoMapper.toDto(milkPurchaseService.getUsersMilkPurchases(searchCriteria).getData());
    }

    // ------------------------------------------------------------------------------

    @ModelAttribute("findPurchases")
    private FindPurchases findPurchasesModelAttribute(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "limit", required = false) String limit,
            @RequestParam(value = "from", required = false) String from,
            @RequestParam(value = "to", required = false) String to
    ) {
        return aFindPurchases()
                .withPage(ofNullable(page).map(Integer::parseInt).orElse(null))
                .withLimit(ofNullable(limit).map(Integer::parseInt).orElse(null))
                .withFrom(ofNullable(from).map(Instant::parse).orElse(null))
                .withTo(ofNullable(to).map(Instant::parse).orElse(null))
                .build();
    }

}
