package pro.buildmysoftware.oop.order.good;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.buildmysoftware.oop.order.common.PlaceOrderCommand;

@RestController
@RequestMapping("/good/orders")
class GoodOrderController {
	private final OrderFacade facade;

	public GoodOrderController(final OrderFacade facade) {
		this.facade = facade;
	}

	@PostMapping
	public void placeOrder(@RequestBody final PlaceOrderCommand command) {
		facade.placeOrder(command);
	}
}
