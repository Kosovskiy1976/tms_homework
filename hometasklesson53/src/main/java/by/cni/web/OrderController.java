package by.cni.web;

import by.cni.dto.OrderDto;
import by.cni.service.OrderService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderDto addOrder(@RequestBody OrderDto order) {
        OrderDto saveOrder = orderService.save(order);
    return saveOrder;
    }
}
