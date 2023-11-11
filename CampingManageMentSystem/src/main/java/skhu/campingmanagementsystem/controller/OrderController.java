package skhu.campingmanagementsystem.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import skhu.campingmanagementsystem.domain.Order;
import skhu.campingmanagementsystem.dto.OrderDto;
import skhu.campingmanagementsystem.dto.request.CreateOrderDto;
import skhu.campingmanagementsystem.dto.resonse.ResponseOrderDto;
import skhu.campingmanagementsystem.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order add(@RequestBody CreateOrderDto orderDto){
        return orderService.addOrder(orderDto);
    }

    @GetMapping("/{id}")
    public OrderDto find(@PathVariable Long id){
        return orderService.findOrderById(id);
    }
}
