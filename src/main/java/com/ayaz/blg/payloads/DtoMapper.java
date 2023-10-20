package com.ayaz.blg.payloads;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ayaz.blg.entities.User;

@Component
public class DtoMapper {
	 @Autowired
     private   ModelMapper mapper;
        
	public  UserDto entityToDto(User user) {
	
		
		UserDto userDto =mapper.map(user, UserDto.class);
		return userDto;

		

	}

	public  User dtoToEntity(UserDto userDto) {
		
	
		 User user = mapper.map(userDto, User.class);
		return user;

	}

	public  List<User> dtoToEntity(List<UserDto> userDto) {
		return userDto.stream().map(m -> dtoToEntity(m)).toList();
	}
	
	
	

}
