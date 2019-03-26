package com.teamapps.milkservice.rest.object;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

/**
 * @author Mihai Alexandru
 * @date 24.12.2018
 */
public class FindPurchases {

    private static final int DEFAULT_LIMIT = 50;

    private static final int DEFAULT_PAGE = 0;

    private int limit;

    private int page;

    private Instant from;

    private Instant to;

    private FindPurchases() {
    }


    public int getLimit() {
        return limit;
    }

    public int getPage() {
        return page;
    }

    public Instant getFrom() {
        return from;
    }

    public Instant getTo() {
        return to;
    }


    public static final class FindPurchasesBuilder {
        private Integer limit = DEFAULT_LIMIT;
        private Integer page = DEFAULT_PAGE;
        private Instant from;
        private Instant to;

        private FindPurchasesBuilder() {
        }

        public static FindPurchasesBuilder aFindPurchases() {
            return new FindPurchasesBuilder();
        }

        public FindPurchasesBuilder withLimit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public FindPurchasesBuilder withPage(Integer page) {
            this.page = page;
            return this;
        }

        public FindPurchasesBuilder withFrom(Instant from) {
            this.from = from;
            return this;
        }

        public FindPurchasesBuilder withTo(Instant to) {
            this.to = to;
            return this;
        }

        public FindPurchases build() {
            FindPurchases findPurchases = new FindPurchases();
            findPurchases.page = resolvePage();
            findPurchases.limit = resolveLimit();
            findPurchases.to = resolveToDate();
            findPurchases.from = resolveFromDate(findPurchases.to);
            return findPurchases;
        }

        private int resolveLimit() {
            return Optional.ofNullable(this.limit).orElse(DEFAULT_LIMIT);
        }

        private int resolvePage() {
            return Optional.ofNullable(this.page).orElse(DEFAULT_PAGE);
        }

        private Instant resolveToDate() {
            return Optional.ofNullable(this.to).orElse(Instant.now(Clock.systemUTC()));
        }

        private Instant resolveFromDate(Instant to) {
            return Optional.ofNullable(this.from).orElse(to.minus(Duration.ofDays(30)));
        }
    }
}
