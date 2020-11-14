package com.capg.restaurant.bill.service;


import com.capg.restaurant.bill.config.CafeMenu;
import com.capg.restaurant.bill.model.Bill;

import java.util.List;

public interface BillService {

    public Bill getOrderBill(List<CafeMenu> purchases);
}
