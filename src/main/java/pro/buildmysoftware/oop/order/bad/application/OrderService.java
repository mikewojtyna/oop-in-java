package pro.buildmysoftware.oop.order.bad.application;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.stereotype.Service;
import pro.buildmysoftware.oop.order.bad.model.Order;
import pro.buildmysoftware.oop.order.bad.repository.OrderRepository;
import pro.buildmysoftware.oop.order.common.OrderLine;

import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final OrderStatisticsService orderStatisticsService;

	public OrderService(final OrderRepository orderRepository,
			    final OrderStatisticsService orderStatisticsService) {
		this.orderRepository = orderRepository;
		this.orderStatisticsService = orderStatisticsService;
	}

	public void placeOrder(final Order order) {
		applyDiscount(order);
		order.setPlaced(true);
		orderRepository.save(order);
		orderStatisticsService.updateStatistics(order);
	}

	private Money calculateTotalCost(final Order order) {
		return order.getLines().stream().map(OrderLine::getPrice)
			.reduce(Money.zero(CurrencyUnit.USD), Money::plus);
	}

	private void applyDiscount(final Order order) {
		final LocalDate now = LocalDate.now();
		if (now.getMonth() == Month.DECEMBER && now
			.getDayOfMonth() < 24) {
			final Money afterDiscount = calculateTotalCost(order)
				.multipliedBy(0.8, RoundingMode.DOWN);
			order.setTotalCost(afterDiscount);
		}
		else {
			final Money totalCost = calculateTotalCost(order);
			if (totalCost.isGreaterThan(Money
				.of(CurrencyUnit.USD, 350))) {
				final Money afterDiscount = totalCost
					.multipliedBy(0.90, RoundingMode.DOWN);
				order.setTotalCost(afterDiscount);
			}
			else if (totalCost.isGreaterThan(Money
				.of(CurrencyUnit.USD, 200))) {
				final Money afterDiscount = totalCost
					.multipliedBy(0.95, RoundingMode.DOWN);
				order.setTotalCost(afterDiscount);
			}
		}
		// repeat this for each other discount
		// ...
	}


}
