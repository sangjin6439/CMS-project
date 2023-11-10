package skhu.campingmanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import skhu.campingmanagementsystem.domain.User;
import skhu.campingmanagementsystem.dto.UserDto;
import skhu.campingmanagementsystem.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public String save(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto find(@PathVariable Long id){
        return userService.findUserByIdAs(id);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UserDto userDto){
        userService.updateUser(id,userDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return userService.deleteUser(id);
    }

}
