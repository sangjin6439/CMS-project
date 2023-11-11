package skhu.campingmanagementsystem.dto.resonse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@AllArgsConstructor
@Jacksonized
public class ResponseOrderDto {

    private Long oderId;
    private String userName;
    private String userPhoneNumber;

}
