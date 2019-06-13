package pro.buildmysoftware.oop.order.bad.model;

import lombok.Data;
import org.joda.money.Money;
import pro.buildmysoftware.oop.order.bad.repository.OrderDateUpdater;
import pro.buildmysoftware.oop.order.common.OrderLine;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(OrderDateUpdater.class)
@Data
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue
	private long id;
	private boolean isPlaced;
	@ElementCollection
	private List<OrderLine> lines;
	private Money totalCost;
	private LocalDateTime date;
}
