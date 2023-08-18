package com.hoaxify.ws.controller;

import com.hoaxify.ws.model.ApiError;
import com.hoaxify.ws.model.User;
import com.hoaxify.ws.repository.UserRepository;
import com.hoaxify.ws.service.UserService;
import com.hoaxify.ws.shared.GenericResponse;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/api/1.0/users")
    public GenericResponse createUser(@Valid @RequestBody User user) {

//        ApiError error = new ApiError(400, "validation error", "/api/1.0/users");
//        Map<String, String> validationErrors = new HashMap<>();
//
//        String username = user.getUsername();
//        String displayName = user.getDisplayName();
//
//        if (username == null || username.isEmpty()) {
//            validationErrors.put("username", "username cannot be null");
//        }
//
//        if (displayName == null || displayName.isEmpty()) {
//            validationErrors.put("displayName", "Cannot be null");
//        }
//        if(validationErrors.size() >0){
//            error.setValidationErrors(validationErrors);
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
//        }

        userService.save(user);
        return new GenericResponse("user created");

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)  // yukardaki yorum satırındaki validation işlemlerini bu şekilde yazdık
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(MethodArgumentNotValidException exception){
        ApiError error = new ApiError(400, "Validation error", "/api/1.0/users");
        Map<String, String> validationErrors = new HashMap<>();

        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        error.setValidationErrors(validationErrors);
        return error;
    }

}
