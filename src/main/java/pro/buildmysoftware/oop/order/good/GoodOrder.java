package pro.buildmysoftware.oop.order.good;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pro.buildmysoftware.oop.order.common.OrderLine;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;

public class GoodOrder {
	private final Collection<OrderLine> orderLines;

	public GoodOrder(final OrderLine... orderLines) {
		this.orderLines = Arrays.asList(orderLines);
	}

	public Money calculateTotalCost(final DiscountPolicy policy) {
		final double discount = policy.discountFor(this);
		return sum().multipliedBy(discount, RoundingMode.DOWN);
	}

	private Money sum() {
		return orderLines.stream().map(OrderLine::getPrice)
			.reduce(Money.zero(CurrencyUnit.USD), Money::plus);
	}
}
