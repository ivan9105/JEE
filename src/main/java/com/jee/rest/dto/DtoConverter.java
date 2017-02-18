package com.jee.rest.dto;

import com.jee.model.User;
import com.jee.rest.dto.xml.UserDto;

/**
 * Created by Иван on 16.02.2017.
 */
public class DtoConverter {
    public static UserDto toUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setAge(user.getAge());
        dto.setName(user.getName());
        dto.setLastname(user.getLastName());
        dto.setId(user.getId());
        return dto;
    }
}
