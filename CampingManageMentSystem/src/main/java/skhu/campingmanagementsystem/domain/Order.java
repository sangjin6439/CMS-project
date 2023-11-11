package skhu.campingmanagementsystem.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import skhu.campingmanagementsystem.dto.OrderDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="Orders")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    //==생성 매서드==//
    public OrderDto toDto() {
        OrderDto order = OrderDto.builder()
                .user(this.user)
                .orderDetails(this.orderDetails)
                .build();
        for (OrderDetail orderDetail : orderDetails) {
            orderDetails.add(orderDetail);
        }
        return order;
    }
}
//    public Order toEntity(Member member, Delivery delivery, OrderItem... orderItems) {
//        Order order = Order.builder()
//                .member(member)
//                .delivery(delivery)
//                .orderDate(LocalDateTime.now())
//                .status(OrderStatus.ORDER)
//                .build();
//        for (OrderItem orderItem : orderItems) {
//            order.addOrderItem(orderItem);
//        }
//        return order;
//    }


