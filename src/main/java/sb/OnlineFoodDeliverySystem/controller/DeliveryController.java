package sb.OnlineFoodDeliverySystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sb.OnlineFoodDeliverySystem.model.Delivery;
import sb.OnlineFoodDeliverySystem.model.Order;
import sb.OnlineFoodDeliverySystem.service.DeliveryService;
import sb.OnlineFoodDeliverySystem.service.OrderService;
import sb.OnlineFoodDeliverySystem.service.impl.DeliveryServiceImpl;
import sb.OnlineFoodDeliverySystem.service.impl.OrderServiceImpl;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/getDeliveryInfo/{orderId}")
    public Delivery getDeliveryInfo(@PathVariable(name = "orderId") Long id) {
        Order order = orderService.getOrderById(id);
        Delivery delivery = deliveryService.getDeliveryInformationByOrder(order);
        return delivery;
    }


    // Assuming that order has been delivered successfully then updating the status to delivered along with time

    @PostMapping("/deliveredDone/{orderId}")
    public Delivery getDeliveredDone(@PathVariable(name = "orderId") Long id) {

        Order order = orderService.getOrderById(id);
        Delivery delivery = deliveryService.UpdateDeliveryByOrder(order);
        return delivery;

    }


}
