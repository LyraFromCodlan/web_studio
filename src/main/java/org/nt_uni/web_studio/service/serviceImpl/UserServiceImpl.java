package org.nt_uni.web_studio.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.nt_uni.web_studio.dao.ClientRepository;
import org.nt_uni.web_studio.dao.UserRepository;
import org.nt_uni.web_studio.mapper.UserMapper;
import org.nt_uni.web_studio.model.base.Client;
import org.nt_uni.web_studio.model.base.User;
import org.nt_uni.web_studio.model.dto.input.UserInput;
import org.nt_uni.web_studio.service.UserService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final UserMapper mapper;
    @Override
    public User registerUser(UserInput input) {
        User user;
        user = mapper.mapUserDtoToUser(input);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UserInput input) {
        User user = userRepository.findByUsername(input.getUsername()).get();
        user = mapper.mapUserDtoToUser(input);
        return userRepository.save(user);
    }

    @Override
    public Client registerClient(UserInput input) {
        Client client;
        client = mapper.mapUserDtoToClient(input);
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(UserInput input) {
        Client client = clientRepository.findByUsername(input.getUsername()).get();
        client = mapper.mapUserDtoToClient(input);
        return clientRepository.save(client);
    }
}
