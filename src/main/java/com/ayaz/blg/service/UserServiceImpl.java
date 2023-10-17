package com.ayaz.blg.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayaz.blg.entities.User;
import com.ayaz.blg.exceptions.ResourceNotFoundException;
import com.ayaz.blg.payloads.DtoMapper;
import com.ayaz.blg.payloads.UserDto;
import com.ayaz.blg.repository.UserRepositroy;

import lombok.extern.slf4j.Slf4j;

@Service

public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepositroy userRepositroy;
	     @Autowired
        private DtoMapper dtoMapper
        ;
	

	@Override
	public UserDto saveUser(UserDto userDto) {
		User user = dtoMapper.dtoToEntity(userDto);
		User saveUser = this.userRepositroy.save(user);
		return  dtoMapper.entityToDto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto) {

		User userDetails = this.userRepositroy.findById(userDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User ", "id", userDto.getId()));
		          userDetails = dtoMapper.dtoToEntity(userDto);
		          User updatedUser = userRepositroy.save(userDetails);
		          return dtoMapper.entityToDto(updatedUser);

	}

	@Override
	public UserDto findUserById(Long id) {

		User user = this.userRepositroy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		return dtoMapper.entityToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> user = this.userRepositroy.findAll();
		   return    user.stream().map(m -> dtoMapper.entityToDto(m)).toList();
		   
	}

	@Override
	public void deleteUser(Long id) {
		Optional<User> findById = this.userRepositroy.findById(id);
		if (!findById.isPresent())
			throw new ResourceNotFoundException("User", "id", id);

		else
			userRepositroy.deleteById(id);

	}

}
