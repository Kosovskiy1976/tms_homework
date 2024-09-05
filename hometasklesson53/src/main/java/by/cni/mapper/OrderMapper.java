package by.cni.mapper;

import by.cni.domain.OrderEntity;
import by.cni.dto.OrderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderEntity toOrderEntity(OrderDto order);
}
