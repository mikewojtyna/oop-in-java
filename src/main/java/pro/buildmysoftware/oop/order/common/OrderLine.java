package pro.buildmysoftware.oop.order.common;

import org.joda.money.Money;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class OrderLine {
	private Money price;

	public OrderLine() {
	}

	public OrderLine(final Money price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderLine{" + "price=" + price + '}';
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final OrderLine orderLine = (OrderLine) o;
		return Objects.equals(price, orderLine.price);
	}

	@Override
	public int hashCode() {

		return Objects.hash(price);
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(final Money price) {
		this.price = price;
	}
}
