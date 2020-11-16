package com.capg.restaurant.bill.config;

import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

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
    private static Map<String,CafeMenu> LOOKUP_BY_NAME_MAP;

    static {
        LOOKUP_BY_NAME_MAP = new HashMap<String, CafeMenu>();
        for (CafeMenu cafeMenu : CafeMenu.values()) {
            LOOKUP_BY_NAME_MAP.put(cafeMenu.getName(), cafeMenu);
        }
        LOOKUP_BY_NAME_MAP = Collections.unmodifiableMap(LOOKUP_BY_NAME_MAP);
    }

    CafeMenu(String name, BrewType brewType, ItemType itemType, BigDecimal price){
        this.name = name;
        this.brewType = brewType;
        this.itemType = itemType;
        this.price = price;
    }

    public static List<CafeMenu> getCafeMenuString(List<String> orders){

        List<CafeMenu> cafeMenus = new ArrayList<>();

        if(!CollectionUtils.isEmpty(orders)){
            orders.stream().forEach(p -> cafeMenus.add(LOOKUP_BY_NAME_MAP.get(p)));
        }

        return cafeMenus;
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
