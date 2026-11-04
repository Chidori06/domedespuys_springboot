package fr.simplon.domedespuys.Entity;

public enum EnumPurchaseStatus {
    PENDING("pending"),
    PAID("paid"),
    SHIPPED("shipped"),
    DELIVERED("delivered"),
    CANCELLED("cancelled");

  EnumPurchaseStatus(String value){}
}
