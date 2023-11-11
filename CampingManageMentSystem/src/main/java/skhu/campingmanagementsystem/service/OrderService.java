package skhu.campingmanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import skhu.campingmanagementsystem.domain.Item;
import skhu.campingmanagementsystem.domain.Order;
import skhu.campingmanagementsystem.domain.OrderDetail;
import skhu.campingmanagementsystem.domain.User;
import skhu.campingmanagementsystem.dto.OrderDto;
import skhu.campingmanagementsystem.dto.request.CreateOrderDto;
import skhu.campingmanagementsystem.dto.resonse.ResponseOrderDto;
import skhu.campingmanagementsystem.repository.ItemRepository;
import skhu.campingmanagementsystem.repository.OrderRepository;
import skhu.campingmanagementsystem.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;


    @Transactional
    public Order addOrder(CreateOrderDto orderDto) {
        User user = userRepository.findUserById(orderDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("찾으시는 회원 정보가 없습니다."));

        Order order = Order.builder()
                .user(user)
                .build();
        orderRepository.save(order);
        return order;
    }


    @Transactional(readOnly = true)
    public OrderDto findOrderById(Long orderId) {
        User user = userRepository.findUserById(orderId).orElseThrow(() -> new IllegalArgumentException("찾으시는 회원 정보가 없습니다."));
        orderRepository.findOrderByUserId(orderId);
        return OrderDto.builder()
                .id(orderId)
                .user(user)
                .build();


    }

}
    /*@Transactional
    public String add (OrderDto orderDto) {
        User user = userRepository.findUserById(orderDto.getId()).orElseThrow(()-> new IllegalArgumentException("찾는 회원 정보가 없습니다."));
//        Item item = itemRepository.findItemById(itemId).orElseThrow(()-> new IllegalArgumentException("찾는 물품 정보가 없습니다."));
        Order order = Order.builder()
                .user(user)
                .build();
        orderRepository.save(order);
        return "주문 완료!!!!";
    }

    @Transactional(readOnly = true)
    public OrderDto findByUserIdAs(Long userId){
        return findByUserId(userId).toDto();

    }

    //조회 메서드
    private Order findByUserId(Long userId){
        return orderRepository.findOrderById(userId).orElseThrow(()->new IllegalArgumentException("찾으시는 회원이 없습니다."));
    }*/
//}
