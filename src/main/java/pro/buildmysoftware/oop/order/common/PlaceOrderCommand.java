package pro.buildmysoftware.oop.order.common;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class PlaceOrderCommand {
	private Collection<OrderLine> orderLines;

	public PlaceOrderCommand() {
	}

	public PlaceOrderCommand(final OrderLine... orderLines) {
		this.orderLines = Arrays.asList(orderLines);
	}

	@Override
	public String toString() {
		return "PlaceOrderCommand{" + "orderLines=" + orderLines + '}';
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final PlaceOrderCommand that = (PlaceOrderCommand) o;
		return Objects.equals(orderLines, that.orderLines);
	}

	@Override
	public int hashCode() {

		return Objects.hash(orderLines);
	}

	public Collection<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(final Collection<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
}
