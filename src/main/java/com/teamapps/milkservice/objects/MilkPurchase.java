package com.teamapps.milkservice.objects;

import java.time.Instant;

/**
 * @author Mihai Alexandru
 * @date 22.12.2018
 */
public class MilkPurchase {

    private Integer id;

    private Integer bottles;

    private Integer bottleQuantity;

    private Instant purchaseDate;

    private String status;

    private MilkPurchase() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getBottles() {
        return bottles;
    }

    public Integer getBottleQuantity() {
        return bottleQuantity;
    }

    public Instant getPurchaseDate() {
        return purchaseDate;
    }

    public String getStatus() {
        return status;
    }


    public static final class MilkPurchaseBuilder {

        private Integer id;

        private Integer bottles;

        private Integer bottleQuantity;

        private Instant purchaseDate;

        private String status;

        private MilkPurchaseBuilder() {
        }

        public static MilkPurchaseBuilder aMilkPurchase() {
            return new MilkPurchaseBuilder();
        }

        public MilkPurchaseBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public MilkPurchaseBuilder withBottles(Integer bottles) {
            this.bottles = bottles;
            return this;
        }

        public MilkPurchaseBuilder withBottleQuantity(Integer bottleQuantity) {
            this.bottleQuantity = bottleQuantity;
            return this;
        }

        public MilkPurchaseBuilder withPurchaseDate(Instant purchaseDate) {
            this.purchaseDate = purchaseDate;
            return this;
        }

        public MilkPurchaseBuilder withStatus(String status) {
            this.status = status;
            return this;
        }

        public MilkPurchase build() {
            MilkPurchase milkPurchase = new MilkPurchase();
            milkPurchase.bottleQuantity = this.bottleQuantity;
            milkPurchase.id = this.id;
            milkPurchase.status = this.status;
            milkPurchase.bottles = this.bottles;
            milkPurchase.purchaseDate = this.purchaseDate;
            return milkPurchase;
        }
    }
}
