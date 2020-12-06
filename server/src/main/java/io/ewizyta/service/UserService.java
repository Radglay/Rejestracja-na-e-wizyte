package io.ewizyta.service;

import io.ewizyta.model.User;
import io.ewizyta.web.dto.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto userRegistrationDto);
}
