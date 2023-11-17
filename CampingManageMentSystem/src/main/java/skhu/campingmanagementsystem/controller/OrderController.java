package skhu.campingmanagementsystem.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import skhu.campingmanagementsystem.domain.Order;
import skhu.campingmanagementsystem.dto.OrderDto;
import skhu.campingmanagementsystem.dto.request.CreateOrderDto;
import skhu.campingmanagementsystem.repository.OrderRepository;
import skhu.campingmanagementsystem.service.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order save(@RequestBody CreateOrderDto createOrderDto){
        return orderService.saveOrder(createOrderDto);
    }

    @DeleteMapping("/{id}")
    public Order delete(@PathVariable Long id){
        return orderService.deleteOrder(id);
    }


//    @GetMapping("/{id}")
//    public OrderDto find(@PathVariable Long id){
//        return orderService.findOrderById(id);
//    }
}
