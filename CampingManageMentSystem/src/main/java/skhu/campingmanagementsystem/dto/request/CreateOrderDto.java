package skhu.campingmanagementsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;
import org.antlr.v4.runtime.misc.NotNull;
import skhu.campingmanagementsystem.dto.ItemDto;
import skhu.campingmanagementsystem.dto.OrderDto;
import skhu.campingmanagementsystem.dto.resonse.ResponseOrderDto;

import java.util.List;


@AllArgsConstructor
@Getter
@Builder
public class CreateOrderDto {

    private Long userId;

    private List<ItemDto> itemDtos;
}
