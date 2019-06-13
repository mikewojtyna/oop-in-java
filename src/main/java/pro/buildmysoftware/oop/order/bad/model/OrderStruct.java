package pro.buildmysoftware.oop.order.bad.model;

import org.joda.money.Money;
import pro.buildmysoftware.oop.order.common.OrderLine;

import java.time.LocalDateTime;
import java.util.List;

public class OrderStruct {
	public long id;
	public boolean isPlaced;
	public List<OrderLine> lines;
	public Money totalCost;
	public LocalDateTime date;
}