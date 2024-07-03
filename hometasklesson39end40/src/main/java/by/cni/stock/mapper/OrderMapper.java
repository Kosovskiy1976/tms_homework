package by.cni.stock.mapper;

import by.cni.stock.domain.OrderEntity;
import by.cni.stock.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "deleted", constant = "no")
    OrderEntity orderDtoToOrderEntity(OrderDto dto);

    OrderDto orderEntityToOrderDto(OrderEntity entity);

    List<OrderDto> orderEntityListToOrderDtoList(List<OrderEntity> entityList);
}
