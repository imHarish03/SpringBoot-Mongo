package io.lab.imHarish03.mapper;

import org.mapstruct.Mapper;

import io.lab.imHarish03.document.Users;
import io.lab.imHarish03.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toEntity(UserDTO dto);
    UserDTO toDto(Users entity);
}
