package com.capg.restaurant.bill.model;

import com.capg.restaurant.bill.config.CafeMenu;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Bill {

    // List of Orders
    private List<CafeMenu> orders;
    // Total Purchased Bill excluding Exluding Tax
    private BigDecimal subTotal;
    // Tax amount which we are not using yet , is for place holder.
    private BigDecimal tax;
    // Service Charge Total for a Order
    private BigDecimal serviceCharge;
    // Total Bill Excluding Services Charges
    private BigDecimal totalBill;
    // Total Order including Service Charges for a Order
    private BigDecimal orderTotal;
}
