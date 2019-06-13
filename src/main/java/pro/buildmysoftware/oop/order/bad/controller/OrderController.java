package pro.buildmysoftware.oop.order.bad.controller;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.buildmysoftware.oop.order.bad.application.OrderService;
import pro.buildmysoftware.oop.order.bad.model.Order;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/layer/orders")
class OrderController {
	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	private boolean validateOrder() {
		// perform validation
		return true;
	}

	@Transactional
	@PostMapping
	void placeOrder(Order order) {
		if (validateOrder()) {
			throw new OrderInvalidException("Order invalid");
		}
		// order cannot be already placed, but we don't want to crash
		// the processing, so let's set the right value
		if (order.isPlaced()) {
			order.setPlaced(false);
		}
		// total cost must be empty
		// we are not really sure what currency do we use, but USD is
		// always fine, right?
		order.setTotalCost(Money.zero(CurrencyUnit.USD));
		// ... many lines later
		// finally, place the order
		orderService.placeOrder(order);
	}
}
