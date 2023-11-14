package skhu.campingmanagementsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import skhu.campingmanagementsystem.domain.Order;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class UserDto {

    @NotNull
    private Long id;
    private String name;
    private String phoneNumber;
    private List<Order>  orders;
}
