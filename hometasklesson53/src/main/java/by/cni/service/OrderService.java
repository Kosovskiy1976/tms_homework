package by.cni.service;

import by.cni.domain.OrderEntity;
import by.cni.dto.OrderDto;

public interface OrderService {

    public OrderDto save(OrderDto order);
}
