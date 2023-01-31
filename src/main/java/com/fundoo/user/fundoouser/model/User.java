package com.fundoo.user.fundoouser.model;

import com.fundoo.user.fundoouser.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(collection = "UserDetails")
public class User {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNo;
    private String dob;
    private LocalDateTime registerDate = LocalDateTime.now();
    private LocalDateTime updatedDate = LocalDateTime.now();
    private boolean verify;
    public String profilePic;

//    public User(UserDto userDto){
//        this.userId =userDto.userId;
//        this.firstName = userDto.firstName;
//        this.lastName = userDto.lastName;
//        this.email = userDto.email;
//        this.password = userDto.password;
//        this.phoneNo = userDto.phoneNo;
//        this.dob = userDto.dob;
//        this.verify = userDto.verify;
//        this.profilePic = userDto.profilePic;
//    }
    public User(String userId ,UserDto userDto){
        this.userId =userId;
        this.firstName = userDto.firstName;
        this.lastName = userDto.lastName;
        this.email = userDto.email;
        this.password = userDto.password;
        this.phoneNo = userDto.phoneNo;
        this.dob = userDto.dob;
        this.verify = userDto.verify;
        this.profilePic = userDto.profilePic;
    }


}
