package by.cni.client;

import by.cni.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "order-client", url = "${app.order.url}", path = "/order")
public interface OrderClient {

    @PostMapping
    OrderDto getResult(@RequestBody OrderDto order);
}
