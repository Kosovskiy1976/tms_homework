package by.cni.stock.servis;

import by.cni.stock.dto.OrderDto;
import by.cni.stock.dto.SearchDto;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;
import java.util.UUID;

public interface OrderServis {

    void createOrder(OrderDto dto);

    List<OrderDto> findAll();

    List<OrderDto> findByName(SearchDto dto);

    OrderDto getById(UUID id);

    List<OrderDto> update(OrderDto dto);
}
