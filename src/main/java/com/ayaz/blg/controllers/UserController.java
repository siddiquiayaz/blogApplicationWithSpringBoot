package com.ayaz.blg.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ayaz.blg.payloads.ResponseHandler;
import com.ayaz.blg.payloads.UserDto;
import com.ayaz.blg.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/userApi")
@RequiredArgsConstructor
public class UserController {  

	private final UserService userService;

	@PostMapping("/save")
	public ResponseEntity<UserDto> saveUser( @Valid @RequestBody UserDto userDto) {

		return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.CREATED);

	}

	@PutMapping("/update-user")
	public ResponseEntity<UserDto> updateUser( @Valid @RequestBody UserDto userDto) {
       return ResponseEntity.ok(userService.updateUser(userDto));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseHandler> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.ok(new ResponseHandler("user deleted succsessfully", true));

	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {

		return ResponseEntity.ok(userService.findUserById(id));

	}

	@GetMapping("/")
	public List<UserDto> getAllUser() {

		return userService.getAllUser();
	}

}
