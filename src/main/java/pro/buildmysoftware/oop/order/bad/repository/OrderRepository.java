package pro.buildmysoftware.oop.order.bad.repository;

import org.springframework.data.repository.CrudRepository;
import pro.buildmysoftware.oop.order.bad.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
