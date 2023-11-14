package skhu.campingmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import skhu.campingmanagementsystem.domain.User;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class OrderDto {

    private Long orderId;
}
