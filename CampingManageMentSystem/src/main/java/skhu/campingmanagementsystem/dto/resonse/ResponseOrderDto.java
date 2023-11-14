package skhu.campingmanagementsystem.dto.resonse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;
import skhu.campingmanagementsystem.domain.Item;
import skhu.campingmanagementsystem.domain.User;
import skhu.campingmanagementsystem.dto.ItemDto;
import skhu.campingmanagementsystem.dto.UserDto;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResponseOrderDto {

    private Long orderId;
    private Long userId;
    private String userName;

}
