package com.example.marketplace.util;

import com.example.marketplace.models.User;
import com.example.marketplace.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private final UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        boolean checkingNull = user.getFirstName() == null || user.getSecondName() == null;
        if(checkingNull){
            errors.reject("Fields must be filled "+ user.getFirstName() + user.getSecondName());
        }

    }

}