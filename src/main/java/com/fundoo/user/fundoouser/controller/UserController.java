package com.fundoo.user.fundoouser.controller;

import com.fundoo.user.fundoouser.dto.LoginDto;
import com.fundoo.user.fundoouser.dto.UserDto;
import com.fundoo.user.fundoouser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public Mono<UserDto> registerUser(@RequestBody Mono<UserDto> userDtoMono){
        return service.registerUser(userDtoMono);
    }

    @GetMapping("/loginUser")
    public Mono<String> loginUser(@RequestBody LoginDto loginDto) {
        return service.loginUser(loginDto);
    }

    @GetMapping("/getById/{userId}")
    public Mono<UserDto> getuserById(@PathVariable String userId){
        return service.getUserById(userId);
    }

    @GetMapping("/getAllUsers")
    public Flux<UserDto> getAllUsers(){
        return service.getAllUsers();
    }

    @PutMapping("/updateUserById/{userId}")
    public Mono<UserDto> updateUserById(@RequestBody Mono<UserDto> userDtoMono, @PathVariable("userId") String userId){
        return service.updateUserById(userDtoMono,userId);
    }

    @DeleteMapping("/deleteById/{userId}")
    public Mono<Void> deleteUserById(@PathVariable String userId){
        return service.deleteUser(userId);

    }

}
