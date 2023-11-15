package skhu.campingmanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import skhu.campingmanagementsystem.domain.Item;
import skhu.campingmanagementsystem.domain.Order;
import skhu.campingmanagementsystem.domain.User;

import skhu.campingmanagementsystem.dto.ItemDto;
import skhu.campingmanagementsystem.dto.OrderDto;
import skhu.campingmanagementsystem.dto.request.CreateOrderDto;
import skhu.campingmanagementsystem.dto.request.RequestItemDto;
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
    public Order saveOrder(CreateOrderDto createOrderDto) {
        User user = userRepository.findUserById(createOrderDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("찾으시는 회원 정보가 없습니다."));

        List<RequestItemDto> itemDtos = createOrderDto.getRequestItemDtos();

        List<Item> items = new ArrayList<>();
        for (RequestItemDto requestItemDto : itemDtos) {
            Item item = itemRepository.findItemById(requestItemDto.getItemId())
                    .orElseThrow(() -> new IllegalArgumentException("찾으시는 상품이 없습니다."));
            items.add(item);
        }

        Order order = Order.builder()
                .user(user)
                .items(items)
                .build();

        return orderRepository.save(order);
    }


//    @Transactional
//    public Order addOrder(CreateOrderDto orderDto) {
//        User user = userRepository.findUserById(orderDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("찾으시는 회원 정보가 없습니다."));
//
//
    //
//        for(OrderDetailDto orderDetailDto : orderDto.getOrderDetailDtos()){
//            Item item = itemRepository.findItemById(orderDetailDto.getItemId()).orElseThrow(()->new IllegalArgumentException("상품 번호를 확인해주세요"));
//            OrderDetail orderDetail = OrderDetail.builder()
//                    .count(orderDetailDto.getCount())
//                    .totalPrice((int) (orderDetailDto.getCount()*item.getPrice()))
//                    .build();
//            Order order = Order.builder()
//                    .orderDetails((List<OrderDetail>) orderDetail)
//                    .user(user)
//                    .build();
//
//        }
//        orderRepository.save(order);
//
//        return order;
//    }
//
//
//    @Transactional(readOnly = true)
//    public OrderDto findOrderById(Long orderId) {
//        User user = userRepository.findUserById(orderId).orElseThrow(() -> new IllegalArgumentException("찾으시는 회원 정보가 없습니다."));
//        orderRepository.findOrderByUserId(orderId);
//        return OrderDto.builder()
//                .id(orderId)
//                .user(user)
//                .build();
//
//
//    }

}

