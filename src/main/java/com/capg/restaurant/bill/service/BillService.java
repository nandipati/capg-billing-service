package com.capg.restaurant.bill.service;


import com.capg.restaurant.bill.config.CafeMenu;
import com.capg.restaurant.bill.model.Bill;

import java.math.BigDecimal;
import java.util.List;

public interface BillService {

    Bill getOrderBill(List<CafeMenu> purchases);

    BigDecimal getServiceCharge(List<CafeMenu> purchases);
}
