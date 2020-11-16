package com.capg.restaurant.bill;

import com.capg.restaurant.bill.config.CafeMenu;
import com.capg.restaurant.bill.model.Bill;
import com.capg.restaurant.bill.service.BillService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BillServiceTests {

	@Autowired
	private BillService billService;

	@Test
	public void getServiceCharge(){
		List<CafeMenu> cafeOrder = new ArrayList<>();
		cafeOrder.add(CafeMenu.COFFEE);
		cafeOrder.add(CafeMenu.CHEESE_SANDWITCH);
		cafeOrder.add(CafeMenu.STEAK_SANDWITCH);
		BigDecimal serviceCharge = billService.getServiceCharge(cafeOrder);
		assertTrue( BigDecimal.valueOf( 0.65).compareTo(serviceCharge) == 0);
	}


	@Test
	public void getServiceChargeError(){

		Throwable throwable = assertThrows(
				IllegalArgumentException.class, () -> {
					billService.getServiceCharge(null);
				}
		);

		assertEquals("Purchases cannot be Empty to calculate Service Charge..", throwable.getMessage());
	}

	@Test
	public void getOrderBillError(){

		Throwable throwable = assertThrows(
				IllegalArgumentException.class, () -> {
					billService.getOrderBill(null);
				}
		);

		assertEquals("Purchases cannot be Empty ..", throwable.getMessage());
	}

	@Test
	public void getOrderBill(){
		List<CafeMenu> cafeOrder = new ArrayList<>();
		cafeOrder.add(CafeMenu.COFFEE);
        cafeOrder.add(CafeMenu.CHEESE_SANDWITCH);
		cafeOrder.add(CafeMenu.STEAK_SANDWITCH);
		Bill bill = billService.getOrderBill(cafeOrder);
		assertTrue(BigDecimal.valueOf(8.15).compareTo(bill.getOrderTotal()) == 0);
		assertTrue(BigDecimal.valueOf(7.50).compareTo(bill.getSubTotal()) == 0);
		assertTrue( BigDecimal.valueOf( 0.65).compareTo(bill.getServiceCharge()) == 0);
	}
}
