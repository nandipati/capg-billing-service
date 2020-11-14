package com.capg.restaurant.bill.config;

import java.math.BigDecimal;

public enum ItemType {

    DRINK(BigDecimal.valueOf(0)),
    FOOD(BigDecimal.valueOf(0.1));

    private BigDecimal serviceChargePercentage;

    ItemType(BigDecimal serviceChargePercentage){
        this.serviceChargePercentage = serviceChargePercentage;
    }

    public BigDecimal getServiceChargePercentage() {
        return serviceChargePercentage;
    }
}
