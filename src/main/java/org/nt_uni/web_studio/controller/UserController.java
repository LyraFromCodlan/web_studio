package org.nt_uni.web_studio.controller;

import lombok.RequiredArgsConstructor;
import org.nt_uni.web_studio.mapper.UserMapper;
import org.nt_uni.web_studio.model.base.Client;
import org.nt_uni.web_studio.model.base.User;
import org.nt_uni.web_studio.model.dto.input.UserInput;
import org.nt_uni.web_studio.model.dto.output.UserOutput;
import org.nt_uni.web_studio.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("hr")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("register/user")
    public ResponseEntity registerUser(@RequestBody UserInput input){
        try {
            User user = userService.registerUser(input);
            UserOutput output = userMapper.mapEntityToDto(user);
            return new ResponseEntity<>(output, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("update/user")
    public ResponseEntity updateUser(@RequestBody UserInput input){
        try {
            User user = userService.updateUser(input);
            UserOutput output = userMapper.mapEntityToDto(user);
            return new ResponseEntity<>(output,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("register/client")
    public ResponseEntity registerClient(@RequestBody UserInput input){
        try {
            Client client = userService.registerClient(input);
            UserOutput output = userMapper.mapEntityToDto(client);
            return new ResponseEntity<>(output, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("update/client")
    public ResponseEntity updateClient(@RequestBody UserInput input){
        try {
            Client client = userService.updateClient(input);
            UserOutput output = userMapper.mapEntityToDto(client);
            return new ResponseEntity<>(output,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
