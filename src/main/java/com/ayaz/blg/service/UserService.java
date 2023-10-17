package com.ayaz.blg.service;

import java.util.List;

import com.ayaz.blg.payloads.UserDto;

public interface UserService {
    public UserDto saveUser(UserDto userDto); 
    public UserDto findUserById(Long id);
    public List<UserDto> getAllUser();
    public void deleteUser(Long Id);
	public UserDto updateUser(UserDto userDto);
	
}
