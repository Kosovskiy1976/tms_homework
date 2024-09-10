package by.cni.repository;

import by.cni.domain.OrderEntity;
import by.cni.dto.OrderDto;
import by.cni.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderRepository {

    public OrderEntity save(OrderEntity orderEntity) {

        return orderEntity;
    }
}
