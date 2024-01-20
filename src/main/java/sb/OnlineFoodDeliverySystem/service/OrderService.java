package sb.OnlineFoodDeliverySystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.OnlineFoodDeliverySystem.Repository.OrderDao;
import sb.OnlineFoodDeliverySystem.model.Order;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderService {


    @Autowired
    private OrderDao orderDao;

    public Order saveOrder(Order order) {
        return orderDao.save(order);
    }


    public List<Order> orderList() {
        return orderDao.findAll();
    }


    public Order getOrderById(Long id) {
        try {
            return orderDao.findById(id).get();
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }


}
