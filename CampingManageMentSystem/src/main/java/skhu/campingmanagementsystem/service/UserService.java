package skhu.campingmanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import skhu.campingmanagementsystem.domain.User;
import skhu.campingmanagementsystem.dto.UserDto;
import skhu.campingmanagementsystem.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service // 꼭 @Transaction 어노테이션 넣자..
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //저장
    @Transactional
    public String save(UserDto userDto){
        User user = saveUser(userDto);
        userRepository.save(user);
        return "저장 완료!";
    }
    //저장 메서드
    private User saveUser(UserDto userDto){
        LocalDateTime dateTime = LocalDateTime.now();
        return User.builder() //절때 아이디 값을 저장하게 하지마!!!!
                .name(userDto.getName())
                .phoneNumber(userDto.getPhoneNumber())
//              .orders(userDto.getOrders())
                .build();
    }

    //한 명 조회
    @Transactional(readOnly = true)
    public UserDto findUserByIdAs(Long memberId){
        return findUserById(memberId).toDto();
       }


    //아이디 조회 메서드
    private User findUserById(Long memberId){
        return userRepository.findUserById(memberId).orElseThrow(()->new IllegalArgumentException("정확한 아이디가 아닙니다"));
    }


    //모두 조회 -> DTO로 반환하는게 너무 어려워서 일단 그냥 엔티티로 반환함
    @Transactional(readOnly = true)
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    //DTO로 모두 조회
    @Transactional(readOnly = true)
    public List<UserDto> findAll(){

        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        for (User user : users) {
//            User user1 = userRepository.findUserById(user.getId()).orElseThrow(); 이 코드를 쓸 이유가 없음, 이미 정보를 가져왔음
            UserDto userDto1 = UserDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .phoneNumber(user.getPhoneNumber())
                    .createAt(user.getCreateAt())
                    .updateAt(user.getUpdateAt())
                    .build();
            userDtos.add(userDto1);
        }
        return userDtos;
    }


    //수정
    @Transactional
    public void updateUser(Long memberId, UserDto userDto){
        User user = findUserById(memberId);
        user.update(userDto);
    }

    //삭제
    @Transactional
    public String deleteUser(Long memberId){
        User user = findUserById(memberId);
        userRepository.delete(user);
        return "삭제 성공";
    }

}
