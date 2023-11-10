package skhu.campingmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import skhu.campingmanagementsystem.domain.User;

@Getter
@Builder
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private User user;

}
