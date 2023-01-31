package com.fundoo.user.fundoouser.service;

import com.fundoo.user.fundoouser.dto.LoginDto;
import com.fundoo.user.fundoouser.dto.UserDto;
import com.fundoo.user.fundoouser.repository.UserRepository;
import com.fundoo.user.fundoouser.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private Mapper modelMapper;
    public Mono<UserDto> registerUser(Mono<UserDto> userDtoMono){
                        //convert dto to model
        return userDtoMono.map(modelMapper::DtoToModel)
                //here it is in model we need to convert it back to dto
                .flatMap(repository::insert)
                //converted model to dto
                .map(modelMapper::ModelToDto);
    }
    public Mono<String> loginUser(LoginDto loginDto) {
        System.out.println("test-2");
        return repository.findByEmail(loginDto.getEmail())
                .map(p->p.getPassword().equals(loginDto.getPassword()) ? "Login Successful.." : "Invalid");
        }
//     public Mono<String> changePassword(String email,String password){
//        return repository.findByEmail(email)
//                .map(e->e.getPassword().equals(password) ? e.setPassword(password); : "Invalid Password");
//     }
//    public Mono<String> forgetPassword(String email, String oldpassword,String newPassword){
//        return repository.findByEmail(email)
//                .map(p->p.getPassword().equals(oldpassword) ? p.setPassword(newPassword); : "Couldn't change password");
//    }
    public Flux<UserDto> getAllUsers(){
        return repository.findAll().map(modelMapper::ModelToDto);
    }
    public Mono<UserDto> getUserById(String userId){
        return repository.findById(userId).map(modelMapper::ModelToDto);
    }
    public Mono<UserDto> updateUserById(Mono<UserDto> userDtoMono, String userId){
                        //finding data from database
        return repository.findById(userId)
                //get requestObject('userDtoMono') converting it from dto to model
                .flatMap(user-> userDtoMono.map(modelMapper::DtoToModel))
                //here updating data of existing userId
                .doOnNext(id->id.setUserId(userId))
                //save updated data into database
                .flatMap(repository::save)
                //again converting back our model to dto
                .map(modelMapper::ModelToDto);
    }
    public Mono<Void> deleteUser(String userId){
        return repository.deleteById(userId);
    }
}
