package pro.buildmysoftware.oop.order.good;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Month;

public class XmasDiscount implements DiscountPolicy {

	private final Clock clock;

	public XmasDiscount(final Clock clock) {
		this.clock = clock;
	}

	/**
	 * Returns 0.8 if date is between 1st and 24th of December, or 1 in
	 * any other case.
	 *
	 * @param order order
	 * @return 0.8 if between 1st (inclusive) and 24th (exclusive) of
	 * December, 1 otherwise
	 */
	@Override
	public double discountFor(final GoodOrder order) {
		final LocalDate now = LocalDate.now(clock);
		if (now.getMonth() == Month.DECEMBER && now
			.getDayOfMonth() < 24) {
			return 0.8;
		}
		return 1;
	}
}
