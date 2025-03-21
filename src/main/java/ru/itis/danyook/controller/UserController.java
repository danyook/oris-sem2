package ru.itis.danyook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.danyook.dto.request.UserRequest;
import ru.itis.danyook.dto.response.UserResponse;
import ru.itis.danyook.service.UserService;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;


    @Override
    public UserResponse getById(UUID uuid) {
        return userService.getById(uuid);
    }

    @Override
    public Set<UserResponse> getAll() {
        return userService.getAll();
    }

    @Override
    public UUID create(UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @Override
    public UUID update(UUID uuid, UserRequest userRequest) {
        return userService.update(uuid, userRequest);
    }

    @Override
    public void delete(UUID uuid) {
        userService.delete(uuid);
    }


}
