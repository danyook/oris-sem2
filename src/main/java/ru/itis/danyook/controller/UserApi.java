package ru.itis.danyook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.danyook.dto.request.UserRequest;
import ru.itis.danyook.dto.response.UserResponse;

import java.util.Set;
import java.util.UUID;

@RequestMapping("/api/v1/users/")
public interface UserApi {

    @GetMapping("/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    UserResponse getById(@PathVariable("user-id") UUID uuid);

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    Set<UserResponse> getAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UUID create(@RequestBody UserRequest userRequest);

    @PutMapping("/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    UUID update(@PathVariable("user-id") UUID uuid, @RequestBody UserRequest userRequest);

    @DeleteMapping("/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("user-id") UUID uuid);


}
