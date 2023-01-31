package com.fundoo.user.fundoouser.util;

import com.fundoo.user.fundoouser.dto.UserDto;
import com.fundoo.user.fundoouser.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public User DtoToModel(UserDto userDto){
        User userDtoToModel = new User();
        BeanUtils.copyProperties(userDto,userDtoToModel);
        return userDtoToModel;
    }

    public UserDto ModelToDto(User user){
        UserDto userModelToDto = new UserDto();
        BeanUtils.copyProperties(user,userModelToDto);
        return userModelToDto;
    }
}
