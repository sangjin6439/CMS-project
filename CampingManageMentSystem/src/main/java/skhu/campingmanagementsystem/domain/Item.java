package skhu.campingmanagementsystem.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Sort;
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
    @ManyToOne
    @JoinColumn(name = " Orders_id")
    private Order order;


    //엔티티 -> Dto
    public ItemDto toDto(){
        return ItemDto.builder()
                .itemId(this.id)
                .name(this.name)
                .price(this.price)
                .build();
    }

    public void update(ItemDto itemDto){
        this.name=itemDto.getName();
        this.price=itemDto.getPrice();
    }

}
