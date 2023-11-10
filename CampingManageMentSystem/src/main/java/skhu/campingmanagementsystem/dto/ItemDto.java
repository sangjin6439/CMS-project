package skhu.campingmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import skhu.campingmanagementsystem.domain.OrderDetail;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ItemDto {

    private Long id;
    private String name;
    private Long price;
    private List<OrderDetail> orderDetails;
}
