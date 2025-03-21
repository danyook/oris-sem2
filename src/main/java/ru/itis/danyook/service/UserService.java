package ru.itis.danyook.service;

import ru.itis.danyook.dto.request.UserRequest;
import ru.itis.danyook.dto.response.UserResponse;

import java.util.Set;
import java.util.UUID;

public interface UserService {

    UserResponse getById(UUID uuid);

    Set<UserResponse> getAll();

    UUID create(UserRequest userRequest);

    UUID update(UUID uuid, UserRequest userRequest);

    void delete(UUID uuid);
}
