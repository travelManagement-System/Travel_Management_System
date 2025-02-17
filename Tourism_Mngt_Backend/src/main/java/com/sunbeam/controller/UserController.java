package com.sunbeam.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.ForgetPasswordDTO;
import com.sunbeam.dto.LoginDTO;
import com.sunbeam.dto.LoginResponse;
import com.sunbeam.dto.UserDTO;
import com.sunbeam.dto.UserResponseDTO;
import com.sunbeam.security.CustomUserDetails;
import com.sunbeam.security.JwtUtils;
import com.sunbeam.service.UserServiceImpl;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	
	  @Autowired 
	  private AuthenticationManager authManager;
	  
	 
	@Autowired
	private JwtUtils utils;
	

	@PostMapping("/register")
	public ResponseEntity<?> addUser(@RequestBody @Valid UserDTO dto){
		String message = userService.addNewUser(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse("success", message));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody 
			@Valid LoginDTO request) {
		System.out.println("in sign in" + request);

		UsernamePasswordAuthenticationToken token=new 
				UsernamePasswordAuthenticationToken(request.getEmail(), 
						request.getPassword());
		//invoke auth mgr's authenticate method;
		Authentication verifiedToken = authManager.authenticate(token);
		
		List<String> roles = verifiedToken.getAuthorities().stream()
                .map(Object::toString)
                .collect(Collectors.toList());
		
		//=> authentication n authorization  successful !
		System.out.println(verifiedToken.getPrincipal().getClass());//custom user details object
		//create JWT n send it to the clnt in response
		LoginResponse resp=new LoginResponse
				(utils.generateJwtToken(verifiedToken),
				"You have been logged in", roles);
		return ResponseEntity.
				status(HttpStatus.CREATED).body(resp);
	}

	@PostMapping("/forget-password")
	public ResponseEntity<?> forgetPassword(@RequestBody @Valid ForgetPasswordDTO dto){
		String message = userService.setPassword(dto);
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("success", message));
	} 
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteUser(@RequestParam String email){
		String message = userService.deleteUser(email);
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("success", message));
	}
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAllUsers(){
		List<UserResponseDTO> allUsers = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(allUsers);
	}
	
}
