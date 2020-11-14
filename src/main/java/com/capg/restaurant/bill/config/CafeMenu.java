package com.capg.restaurant.bill.config;

import java.math.BigDecimal;

public enum CafeMenu {

    COLA("Cola",BrewType.Cold,ItemType.DRINK,BigDecimal.valueOf(0.50)),
    COFFEE("Coffee",BrewType.Hot,ItemType.DRINK,BigDecimal.valueOf(1.00)),
    CHEESE_SANDWITCH("Cheese Sandwich",BrewType.Cold,ItemType.FOOD,BigDecimal.valueOf(2.00)),
    STEAK_SANDWITCH("Steak Sandwich",BrewType.Hot,ItemType.FOOD,BigDecimal.valueOf(4.50));

    private String name;
    private BrewType brewType;
    private ItemType itemType;
    private BigDecimal price;
    private Integer serviceCharge;

    CafeMenu(String name, BrewType brewType, ItemType itemType, BigDecimal price){
        this.name = name;
        this.brewType = brewType;
        this.itemType = itemType;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BrewType getBrewType() {
        return brewType;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
