package by.cni.service.impl;

import by.cni.client.OrderClient;
import by.cni.domain.OrderEntity;
import by.cni.domain.Status;
import by.cni.dto.OrderDto;
import by.cni.mapper.OrderMapper;
import by.cni.repository.OrderRepository;
import by.cni.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderClient client;
    private final OrderMapper orderMapper;

    @Override
    public OrderDto save(OrderDto order) {

        OrderDto result = client.getResult(order);
        if (result.getStatus().equals(Status.accepted)){
            OrderEntity orderEntity = orderMapper.toOrderEntity(result);
            orderRepository.save(orderEntity);
            return result;
        }

        throw new RuntimeException();
    }
}
