package vn.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import vn.demo.dto.response.ResponseUserDetail;
import vn.demo.model.User;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Operation(summary = "Create new user", description = "API for insert user into databases")
    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        return "User added";
    }


    @Operation(summary = "Update user", description = "API for update user into databases")
    @PutMapping("/update")
    public String updateUser( @RequestBody User user) {
        log.info("Request update user={}", user.getId());
        return "User updated";
    }


    @Operation(summary = "Delete user", description = "API for delete user into databases")
    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") long userId) {
        log.info("Request delete user={}", userId);
        return "User deleted";
    }


    @Operation(summary = "Get detail user", description = "API for get user by id into databases")
    @GetMapping("/{userId}")
    public ResponseUserDetail getUserById(@PathVariable("userId") long userId) {
        log.info("Request detail user={}", userId);
        return new ResponseUserDetail("Nhan", "Mai", "09/01/2024","MALE" , "1234567894", "MaiVanNhan",
                "123456","Quang Nam","Vietnames");
    }

    @Operation(summary = "Get list user", description = "API for get list user into databases")
    @GetMapping("/list")
    public List<ResponseUserDetail> getListUsers() {
        log.info("Request list user={}");
        return List.of(new ResponseUserDetail("Nhan", "Mai", "09/01/2024","MALE" , "1234567894", "MaiVanNhan",
                "123456","Quang Nam","Vietnames"),
                new ResponseUserDetail("Hanh", "Nguyen", "09/01/2024","MALE" , "1234567894", "MaiVanNhan",
                        "123456","Quang Nam","Vietnames")) ;
    }
}
