package com.samsung.premasterclassspringsecurity.rest.dto;

import com.samsung.premasterclassspringsecurity.domain.Role;
import com.samsung.premasterclassspringsecurity.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Getter
public class UserDto {
    private final String email;
    private final String fullName;
    private final String password;
    private final Role role;

    public static UserDto toDto(User user) {
        return UserDto.builder().email(user.getEmail()).fullName(user.getFullname())
                .password(user.getPassword()).role(user.getRole()).build();
    }

    public static User fromDto(UserDto userDto) {
        return User.builder().email(userDto.getEmail()).fullname(userDto.getFullName())
                .password(userDto.getPassword()).role(userDto.getRole()).build();
    }
}
