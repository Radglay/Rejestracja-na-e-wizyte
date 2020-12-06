package io.ewizyta.service;

import io.ewizyta.model.User;
import io.ewizyta.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto userRegistrationDto);
}
