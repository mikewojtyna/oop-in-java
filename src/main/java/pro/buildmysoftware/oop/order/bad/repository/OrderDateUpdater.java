package pro.buildmysoftware.oop.order.bad.repository;

import pro.buildmysoftware.oop.order.bad.model.Order;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class OrderDateUpdater {
	@PrePersist
	void updateDate(Order order) {
		// update to the current time
		order.setDate(LocalDateTime.now());
	}
}
