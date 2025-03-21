package ru.itis.danyook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.danyook.dto.request.UserRequest;
import ru.itis.danyook.dto.response.UserResponse;
import ru.itis.danyook.mapper.UserMapper;
import ru.itis.danyook.model.UserEntity;
import ru.itis.danyook.repository.UserRepository;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BaseUserService implements UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserMapper userMapper;

    @Override
    public UserResponse getById(UUID uuid) {
        return userMapper.toResponse(userRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Not found user with uuid = %s".formatted(uuid))));
    }

    @Override
    public Set<UserResponse> getAll() {
        return userRepository.findAll().stream().map(userMapper::toResponse).collect(Collectors.toSet());
    }

    @Override
    public UUID create(UserRequest userRequest) {
        UserEntity user = userMapper.toEntity(userRequest);
        return userRepository.save(user).getId();
    }

    @Override
    public UUID update(UUID uuid, UserRequest userRequest) {
        UserEntity user = userMapper.toEntity(userRequest);
        user.setId(uuid);
        return userRepository.save(user).getId();
    }

    @Override
    public void delete(UUID uuid) {
        userRepository.deleteById(uuid);
    }

}
