 package com.ayaz.blg.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
  
public class UserDto {
	

    private Long id;
    @NotEmpty(message = "username is must but 5 character")
    @Size(min = 5)
	private String name;
    @Email(message = "email is not valid")
	private String email;
    @NotEmpty
    @Size(min =8 , max =16 , message ="password must 8 to 16 character")
	private String password;
    @NotEmpty( message ="about is required")
	private String about;


}
