package fr.simplon.domedespuys.Entity;

import lombok.Getter;

@Getter
public enum EnumPurchaseStatus {

    PENDING("pending"),
    PAID("paid"),
    SHIPPED("shipped"),
    DELIVERED("delivered"),
    CANCELLED("cancelled");

    private final String value;

    EnumPurchaseStatus(String value) {
        this.value = value;
    }
}
