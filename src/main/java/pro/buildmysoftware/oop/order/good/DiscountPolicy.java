package pro.buildmysoftware.oop.order.good;

interface DiscountPolicy {
	double discountFor(GoodOrder goodOrder);
}
