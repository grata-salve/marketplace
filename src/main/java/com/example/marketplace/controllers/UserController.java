package com.example.marketplace.controllers;

import com.example.marketplace.dto.IdDto;
import com.example.marketplace.dto.ProductResponse;
import com.example.marketplace.dto.UserDTO;
import com.example.marketplace.dto.UserResponse;
import com.example.marketplace.models.User;
import com.example.marketplace.services.UserService;
import com.example.marketplace.util.UserValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.marketplace.util.ErrorsUtil.returnErrorsToClient;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final UserValidator userValidator;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper, UserValidator userValidator) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.userValidator = userValidator;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid UserDTO userDTO,
                                          BindingResult bindingResult){
        User userToAdd = convertToUser(userDTO);
        userValidator.validate(userToAdd, bindingResult);

        if(bindingResult.hasErrors()){
            returnErrorsToClient(bindingResult);
        } else {
            System.out.println(userToAdd);
            userService.register(userToAdd);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public  UserResponse getProducts() {
        return new UserResponse(userService.findAll().stream().map(this::convertToUserDTO)
                .collect(Collectors.toList()));
    }

    @DeleteMapping("/delete/{id}")
   public void deleteUser(@PathVariable Integer id) {
            userService.deleteUser(id);
    }

    @PostMapping("/buy")
    public ResponseEntity<HttpStatus> addProduct(@RequestBody @Valid IdDto idDto) {
        userService.setBuyer(idDto.getUserId(), idDto.getProductID());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/product_buyer/{id}")
    public UserResponse userProducts(@PathVariable int id){
        return new UserResponse(userService.productBuyer(id).stream().map(this::convertToUserDTO)
                .collect(Collectors.toList()));
    }

    private User convertToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    private UserDTO convertToUserDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }

}
