package sb.OnlineFoodDeliverySystem.service;

import sb.OnlineFoodDeliverySystem.model.Order;

public interface OrderService {

    Order saveOrder(Order order);

    Order getOrderById(Long id);
}
