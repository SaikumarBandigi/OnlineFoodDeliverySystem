package sb.OnlineFoodDeliverySystem.service;

import sb.OnlineFoodDeliverySystem.model.Delivery;
import sb.OnlineFoodDeliverySystem.model.Order;

public interface DeliveryService {

    Delivery SaveDelivery(Delivery delivery);

    Delivery getDeliveryInformationByOrder(Order order);

    Delivery UpdateDeliveryByOrder(Order order);
}
