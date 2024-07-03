package by.cni.stock.web;

import by.cni.stock.domain.OrderEntity;
import by.cni.stock.dto.OrderDto;
import by.cni.stock.dto.SearchDto;
import by.cni.stock.repository.OrderRepository;
import by.cni.stock.servis.OrderServis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderServis orderServis;

    @Transactional
    @GetMapping
    public String home(@RequestParam(name = "id", required = false) UUID id,
                       @RequestParam(name = "deleted", required = false) String deleted,
                       Model model) {
        if (id != null && deleted.equals("no")) {
            OrderEntity byId = orderRepository.getById(id);
            byId.setDeleted("yes");
        }

        if (id != null && deleted.equals("yes")) {
            OrderEntity byId = orderRepository.getById(id);
            byId.setDeleted("no");
        }

        var all = orderServis.findAll();
        model.addAttribute("orders", all);
        return "home";
    }

    @PostMapping
    public String add(OrderDto dto, Model model) {
        orderServis.createOrder(dto);
        model.addAttribute("orders", orderServis.findAll());
        return "home";
    }

    @PostMapping("/search")
    public String search(SearchDto dto, Model model) {
        var result = orderServis.findByName(dto);
        model.addAttribute("orders", result);
        return "home";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") UUID id, Model model) {
        OrderDto byId = orderServis.getById(id);
        model.addAttribute("order", byId);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(OrderDto dto, Model model) {
        List<OrderDto> update = orderServis.update(dto);
        model.addAttribute("orders", update);
        return "home";
    }

}
