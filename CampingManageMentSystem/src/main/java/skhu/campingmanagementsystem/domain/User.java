package skhu.campingmanagementsystem.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.*;
import skhu.campingmanagementsystem.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    // 아이템-> dto
    public UserDto toDto(){
        return UserDto.builder()
                .id(this.id)
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                .orders(this.orders)
                .build();
    }

//    public void update(UserDto userDto){
//        this.name=userDto.getName();
//        this.phoneNumber= userDto.getPhoneNumber();
//    }

    public void update(UserDto userDto){
        this.name=userDto.getName();
        this.phoneNumber=userDto.getPhoneNumber();
        this.orders=userDto.getOrders();
    }
}
