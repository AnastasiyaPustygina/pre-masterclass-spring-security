package com.samsung.premasterclassspringsecurity.service;

import com.samsung.premasterclassspringsecurity.domain.User;

public interface UserService {
    User save(User user);

    User findByEmail(String email);
}
