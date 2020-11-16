package com.capg.restaurant.bill.service.impl;

import com.capg.restaurant.bill.config.CafeMenu;
import com.capg.restaurant.bill.model.Bill;
import com.capg.restaurant.bill.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Slf4j
@Service
public class BillServiceImpl implements BillService {

    public Bill getOrderBill(List<CafeMenu> purchases){

        if(CollectionUtils.isEmpty(purchases)){
            throw new IllegalArgumentException("Purchases cannot be Empty ..");
        }

        BigDecimal totalBill = purchases.stream().map(CafeMenu::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.CEILING);

        BigDecimal serviceChargeTotal = getServiceCharge(purchases);


        BigDecimal orderTotal = totalBill.add(serviceChargeTotal);

        Bill bill = createBillValueObject(purchases, totalBill, serviceChargeTotal, orderTotal);

        log.info("Order Bill attributes ->{}",bill.toString());

        return bill;
    }

     BigDecimal getServiceCharge(List<CafeMenu> purchases) {
        BigDecimal serviceChargeTotal = purchases.stream().map(p->
                p.getPrice().multiply(p.getItemType().getServiceChargePercentage()))
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.CEILING);
        return serviceChargeTotal;
    }

    private Bill createBillValueObject(List<CafeMenu> purchases, BigDecimal purchaseTotal, BigDecimal serviceChargeTotal, BigDecimal orderTotal) {
        Bill bill = new Bill();
        bill.setOrders(purchases);
        bill.setSubTotal(purchaseTotal);
        bill.setServiceCharge(serviceChargeTotal);
        bill.setTotalBill(purchaseTotal);
        bill.setOrderTotal(orderTotal);
        return bill;
    }
}
