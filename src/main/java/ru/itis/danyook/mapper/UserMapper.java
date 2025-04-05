package ru.itis.danyook.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.danyook.dto.request.UserRequest;
import ru.itis.danyook.dto.response.UserResponse;
import ru.itis.danyook.model.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "password", ignore = true)
    UserEntity toEntity(UserRequest userRequest);

    UserResponse toResponse(UserEntity userEntity);

}