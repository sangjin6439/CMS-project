package skhu.campingmanagementsystem.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 엔티티는 프록시 때문에 기본생성자를 필요로 하기에 기본생성자를 만들어 준다. 범위는 protected로 지정
public class OrderDetail extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderId")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="itemId")
    private Item item;

}
