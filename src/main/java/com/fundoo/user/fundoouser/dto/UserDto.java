package com.fundoo.user.fundoouser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    public String userId;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phoneNo;
    public String dob;
    public boolean verify = false;
    public String profilePic;
}
