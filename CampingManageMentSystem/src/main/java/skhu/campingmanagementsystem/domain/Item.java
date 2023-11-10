package skhu.campingmanagementsystem.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import skhu.campingmanagementsystem.dto.ItemDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Item extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;

    @JsonIgnore
    @OneToMany(mappedBy = "item")
    private List<OrderDetail> orderDetails = new ArrayList<>();

    //엔티티 -> Dto
    public ItemDto toDto(){
        return ItemDto.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .orderDetails(this.orderDetails)
                .build();
    }

    public void update(ItemDto itemDto){
        this.name=itemDto.getName();
        this.price=itemDto.getPrice();
        this.orderDetails= itemDto.getOrderDetails();
    }

}
