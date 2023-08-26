package com.userservice.controller;

 import com.userservice.dto.UserRequestDto;
 import com.userservice.dto.UserResponseDto;
 import com.userservice.service.UserService;
 import com.userservice.serviceImpl.UserServiceImpl;
 import jakarta.validation.Valid;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

 import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> addUser(@Valid @RequestBody UserRequestDto userRequestDto)
    {
        logger.info("user data----------------------------: {}", userRequestDto);
        return userService.saveUser(userRequestDto);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUser()
    {
        return userService.fetchAllUser();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") Long id)
    {
        return  userService.fetchUserById(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserRequestDto userRequestDto)
    {
        return  userService.editUser(id, userRequestDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id)
    {
        return userService.deleteUser(id);
    }
}
