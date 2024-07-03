package by.cni.stock.servis.impl;

import by.cni.stock.domain.OrderEntity;
import by.cni.stock.dto.OrderDto;
import by.cni.stock.dto.SearchDto;
import by.cni.stock.mapper.OrderMapper;
import by.cni.stock.repository.OrderRepository;
import by.cni.stock.servis.OrderServis;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServisImpl implements OrderServis {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public void createOrder(OrderDto dto) {
        OrderEntity entity = orderMapper.orderDtoToOrderEntity(dto);
        orderRepository.save(entity);
    }

    @Override
    public List<OrderDto> findAll() {
        return orderMapper.orderEntityListToOrderDtoList(orderRepository.findAll());
    }

    @Override
    public List<OrderDto> findByName(SearchDto dto) {
        return orderMapper.orderEntityListToOrderDtoList(orderRepository.findByName(dto.getSearch()));
    }

    @Override
    public OrderDto getById(UUID id) {
        return orderMapper.orderEntityToOrderDto(orderRepository.getById(id));
    }

    @Transactional
    @Override
    public List<OrderDto> update(OrderDto dto) {
        OrderEntity byId = orderRepository.getById(dto.getId());
        byId.setName(dto.getName());
        byId.setPrice(dto.getPrice());
        byId.setQuantity(dto.getQuantity());
        return orderMapper.orderEntityListToOrderDtoList(orderRepository.findAll());
    }
}
