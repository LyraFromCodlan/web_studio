package org.nt_uni.web_studio.security.controller;

import lombok.RequiredArgsConstructor;
import org.nt_uni.web_studio.security.dto.AuthUserInput;
import org.nt_uni.web_studio.security.dto.AuthUserOutput;
import org.nt_uni.web_studio.security.mapper.AuthUserMapper;
import org.nt_uni.web_studio.security.model.AuthClient;
import org.nt_uni.web_studio.security.model.AuthUser;
import org.nt_uni.web_studio.security.service.AuthUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthUserService userService;
    private final AuthUserMapper authUserMapper;

    @PostMapping("register/user")
    public ResponseEntity registerUser(@RequestBody AuthUserInput input){
        try {
            AuthUser authUser = userService.registerUser(input);
            AuthUserOutput output = authUserMapper.mapEntityToDto(authUser);
            return new ResponseEntity<>(output, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("update/user")
    public ResponseEntity updateUser(@RequestBody AuthUserInput input){
        try {
            AuthUser user = userService.updateUser(input);
            AuthUserOutput output = authUserMapper.mapEntityToDto(user);
            return new ResponseEntity<>(output,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("register/client")
    public ResponseEntity registerClient(@RequestBody AuthUserInput input){
        try {
            AuthClient authUser = userService.registerClient(input);
            AuthUserOutput output = authUserMapper.mapEntityToDto(authUser);
            return new ResponseEntity<>(output, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("update/client")
    public ResponseEntity updateClient(@RequestBody AuthUserInput input){
        try {
            AuthClient user = userService.updateClient(input);
            AuthUserOutput output = authUserMapper.mapEntityToDto(user);
            return new ResponseEntity<>(output,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
