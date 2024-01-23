package sb.OnlineFoodDeliverySystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.OnlineFoodDeliverySystem.Repository.DeliveryDao;
import sb.OnlineFoodDeliverySystem.model.Delivery;
import sb.OnlineFoodDeliverySystem.model.Order;
import sb.OnlineFoodDeliverySystem.service.DeliveryService;

import java.time.LocalDateTime;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryDao deliveryDao;


    @Override
    public Delivery SaveDelivery(Delivery delivery) {
        return deliveryDao.save(delivery);
    }

    @Override
    public Delivery getDeliveryInformationByOrder(Order order) {
        return deliveryDao.findByOrder(order);
    }

    @Override
    public Delivery UpdateDeliveryByOrder(Order order) {

        Delivery delivery = deliveryDao.findByOrder(order);
// as of now giving present time and delivered message
        delivery.setDeliveryDate(LocalDateTime.now());
        delivery.setStatus("Delivered");

        return deliveryDao.save(delivery);


    }


}
