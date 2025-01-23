package vn.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.demo.dto.response.ResponseData;
import vn.demo.dto.response.ResponseError;
import vn.demo.dto.response.user.ResponseUserDetail;
import vn.demo.model.User;
import vn.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @Operation(summary = "Create new user", description = "API for insert user into databases")
    @PostMapping("/add")
    public ResponseData<?> addUser(@Valid @RequestBody User user) {
        log.info("Request create user={}", user.getId());
        try {
            userService.addUser(user);
            return new ResponseData<>(HttpStatus.CREATED.value(), "user added successfully", 1);
        } catch (Exception e) {
            log.error("errorMessage= {} ", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Add user failed");
        }
    }


    @Operation(summary = "Update user", description = "API for update user into databases")
    @PutMapping("/update")
    public ResponseData<?> updateUser(@RequestBody User user) {
        log.info("Request update user={}", user.getId());
        try {
            return new ResponseData<>(HttpStatus.ACCEPTED.value(), "user update successfully");
        } catch (Exception e) {
//            log.error("errorMessage= {} ", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Add user failed");
        }
    }


    @Operation(summary = "Delete user", description = "API for delete user into databases")
    @DeleteMapping("/delete/{userId}")
    public ResponseData<?> deleteUser(@Min(1) @PathVariable("userId") long userId) {
        log.info("Request delete user={}", userId);

        try {
            return new ResponseData<>(HttpStatus.OK.value(), "user delete successfully");
        } catch (Exception e) {
//            log.error("errorMessage= {} ", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Add user failed");
        }
    }


    @Operation(summary = "Get detail user", description = "API for get user by id into databases")
    @GetMapping("/{userId}")
    public ResponseData<ResponseUserDetail> getUserById(@PathVariable("userId") long userId) {
        log.info("Request detail user={}", userId);

        try {
            return new ResponseData<>(HttpStatus.OK.value(), "user detail successfully", new ResponseUserDetail("Nhan", "Mai", "09/01/2024", "MALE", "1234567894", "MaiVanNhan",
                    "123456", "Quang Nam", "Vietnames"));
        } catch (Exception e) {
//            log.error("errorMessage= {} ", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Add user failed");
        }
    }

    @Operation(summary = "Get list user", description = "API for get list user into databases")
    @GetMapping("/list")
    public ResponseData<List<ResponseUserDetail>> getListUsers(@RequestParam(defaultValue = "0", required = false ) int pageNo,
                                                              @Min(10) @RequestParam(defaultValue = "10", required = false ) int pageSize )

                         {
        log.info("Request list user={}");

        try {
            return new ResponseData<>(HttpStatus.OK.value(), "get list users successfully", List.of(new ResponseUserDetail("Nhan", "Mai", "09/01/2024", "MALE", "1234567894", "MaiVanNhan",
                            "123456", "Quang Nam", "Vietnames"),
                    new ResponseUserDetail("Hanh", "Nguyen", "09/01/2024", "MALE", "1234567894", "MaiVanNhan",
                            "123456", "Quang Nam", "Vietnames")));
        } catch (Exception e) {
//            log.error("errorMessage= {} ", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Add user failed");
        }
    }
}
