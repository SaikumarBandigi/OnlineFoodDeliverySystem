package sb.OnlineFoodDeliverySystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.OnlineFoodDeliverySystem.Repository.OrderDao;
import sb.OnlineFoodDeliverySystem.model.Delivery;
import sb.OnlineFoodDeliverySystem.model.Order;
import sb.OnlineFoodDeliverySystem.model.UserInfo;
import sb.OnlineFoodDeliverySystem.service.OrderService;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order saveOrder(Order order) {

        UserInfo userInfo = order.getUser();
        order.setUser(userInfo);

        return orderDao.save(order);

    }

    @Override
    public Order getOrderById(Long id) {
        return orderDao.findById(id).get();
    }


}
