package org.nt_uni.web_studio.service;

import org.nt_uni.web_studio.model.base.Client;
import org.nt_uni.web_studio.model.base.User;
import org.nt_uni.web_studio.model.dto.input.UserInput;

public interface UserService {
    User registerUser(UserInput input);
    User updateUser(UserInput input);
    Client registerClient(UserInput input);
    Client updateClient(UserInput input);
}
