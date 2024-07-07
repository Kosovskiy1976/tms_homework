package by.cni.stock.servis.impl;

import by.cni.stock.domain.OrderEntity;
import by.cni.stock.dto.OrderDto;
import by.cni.stock.dto.SearchDto;
import by.cni.stock.mapper.OrderMapper;
import by.cni.stock.repository.OrderRepository;
import by.cni.stock.servis.OrderServis;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public List<OrderDto> findByName(SearchDto searchDto) {
        return orderMapper.orderEntityListToOrderDtoList(orderRepository.findByName(searchDto.getSearch()));
    }

    @Override
    public OrderDto getById(UUID id) {
        return orderMapper.orderEntityToOrderDto(orderRepository.getReferenceById(id));
    }

    @Transactional
    @Override
    public List<OrderDto> update(OrderDto dto) {
        OrderEntity byId = orderRepository.getReferenceById(dto.getId());
        byId.setName(dto.getName());
        byId.setPrice(dto.getPrice());
        byId.setQuantity(dto.getQuantity());
        byId.setDelivered(dto.getDelivered());
        return orderMapper.orderEntityListToOrderDtoList(orderRepository.findAll());
    }

    @Override
    public List<OrderDto> search(SearchDto dto) {
        return orderMapper.orderEntityListToOrderDtoList(orderRepository.findAll(createSpecification(dto)));
    }

    private Specification<OrderEntity> createSpecification(SearchDto dto) {
        return (root, query, criteriaBuilder) -> {
            ArrayList<Predicate> predicates = new ArrayList<>();

            String search = dto.getSearch();
            if (search != null && !search.isEmpty()) {
                Predicate namePred = criteriaBuilder.equal(root.get("name"), search);
                predicates.add(namePred);
            }

            Integer price = dto.getPrice();
            if (price != null) {
                Predicate pricePred = criteriaBuilder.lessThan(root.get("price"), price);
                predicates.add(pricePred);
            }

            Integer quantity = dto.getQuantity();
            if (quantity != null) {
                Predicate quantityPred = criteriaBuilder.greaterThan(root.get("quantity"), quantity);
                predicates.add(quantityPred);
            }

            Boolean delivered = dto.getDelivered();
            if (delivered != null) {
                Predicate deliveredPred = criteriaBuilder.equal(root.get("delivered"), delivered);
                predicates.add(deliveredPred);
            }

            Predicate predicate = criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            return predicate;
        };
    }
}
