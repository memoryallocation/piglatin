package com.skynet.translator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skynet.translator.dto.LoginRequestDTO;
import com.skynet.translator.dto.LoginResponseDTO;
import com.skynet.translator.dto.SignupRequestDTO;
import com.skynet.translator.dto.UserDTO;
import com.skynet.translator.entity.User;
import com.skynet.translator.services.TokenService;
import com.skynet.translator.utils.WrapperResponse;

@RestController
public class TokenController {
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping(value="/login")
	public ResponseEntity<WrapperResponse<LoginResponseDTO>> login(@RequestBody LoginRequestDTO request) {
		LoginResponseDTO response = userService.login(request);
		return new WrapperResponse<LoginResponseDTO>(true, "success", response).createResponse();

	}

}
