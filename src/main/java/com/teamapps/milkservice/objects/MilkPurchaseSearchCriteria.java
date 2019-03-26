package com.teamapps.milkservice.objects;

import java.time.Instant;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

/**
 * @author Mihai Alexandru
 * @date 22.12.2018
 */
public class MilkPurchaseSearchCriteria {

    private static final int DEFAULT_LIMIT = 50;

    private Instant from;

    private Instant to;

    private int limit;

    private int page;

    private MilkPurchaseSearchCriteria() {
    }

    public Instant getFrom() {
        return from;
    }

    public Instant getTo() {
        return to;
    }

    public int getLimit() {
        return limit;
    }

    public int getPage() {
        return page;
    }

    public static final class MilkPurchaseSearchCriteriaBuilder {
        private Instant from;
        private Instant to;
        private int limit;
        private int page;

        private MilkPurchaseSearchCriteriaBuilder() {
        }

        public static MilkPurchaseSearchCriteriaBuilder aMilkPurchaseSearchCriteria() {
            return new MilkPurchaseSearchCriteriaBuilder();
        }

        public MilkPurchaseSearchCriteriaBuilder withFrom(Instant from) {
            this.from = from;
            return this;
        }

        public MilkPurchaseSearchCriteriaBuilder withTo(Instant to) {
            this.to = to;
            return this;
        }

        public MilkPurchaseSearchCriteriaBuilder withLimit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public MilkPurchaseSearchCriteriaBuilder withPage(Integer page) {
            this.limit = limit;
            return this;
        }

        public MilkPurchaseSearchCriteria build() {
            MilkPurchaseSearchCriteria milkPurchaseSearchCriteria = new MilkPurchaseSearchCriteria();
            milkPurchaseSearchCriteria.limit = Optional.ofNullable(this.limit).orElse(DEFAULT_LIMIT);
            milkPurchaseSearchCriteria.from = this.from;
            milkPurchaseSearchCriteria.to = this.to;
            milkPurchaseSearchCriteria.page = requireNonNull(this.page);
            return milkPurchaseSearchCriteria;
        }
    }
}
