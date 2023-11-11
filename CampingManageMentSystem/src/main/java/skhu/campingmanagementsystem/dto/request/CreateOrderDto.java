package skhu.campingmanagementsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;
import org.antlr.v4.runtime.misc.NotNull;


@AllArgsConstructor
@Getter
@Builder
@Jacksonized //JSON parse error: 뭐시기 오류떠서 입력함
public class CreateOrderDto {

    private Long userId;
}
