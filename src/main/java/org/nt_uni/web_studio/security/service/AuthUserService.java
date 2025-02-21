package org.nt_uni.web_studio.security.service;

import lombok.RequiredArgsConstructor;
import org.nt_uni.web_studio.security.dto.AuthUserInput;
import org.nt_uni.web_studio.security.model.AuthClient;
import org.nt_uni.web_studio.security.model.AuthUser;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthUserService{

    public AuthUser registerUser(AuthUserInput input) {
        return null;
    }

    public AuthUser updateUser(AuthUserInput input) {
        return null;
    }

    public AuthClient registerClient(AuthUserInput input) {
        return null;
    }

    public AuthClient updateClient(AuthUserInput input) {
        return null;
    }
}
