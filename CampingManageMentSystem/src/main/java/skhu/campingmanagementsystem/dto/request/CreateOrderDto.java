package skhu.campingmanagementsystem.dto.request;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.antlr.v4.runtime.misc.NotNull;
import skhu.campingmanagementsystem.dto.ItemDto;
import skhu.campingmanagementsystem.dto.OrderDto;

import java.util.List;


@Data
public class CreateOrderDto {

    private Long userId;

    private List<RequestItemDto> requestItemDtos;

}
