package org.nt_uni.web_studio.security.service;

import lombok.RequiredArgsConstructor;
import org.nt_uni.web_studio.security.model.AuthClient;
import org.nt_uni.web_studio.security.model.Authority;
import org.nt_uni.web_studio.security.model.AuthUser;
import org.nt_uni.web_studio.security.model.repository.AuthClientRepository;
import org.nt_uni.web_studio.security.model.repository.AuthUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AuthUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService, Serializable {
    private final AuthUserRepository authUserRepository;
    private final AuthClientRepository authClientRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthUser> authUserOptional = authUserRepository.findByUsername(username);
        Optional<AuthClient> authClientOptional = authClientRepository.findByUsername(username);

        if (authUserOptional.isPresent()) {
            AuthUser authUser = authUserOptional.get();
            return new org.springframework.security.core.userdetails.User(authUser.getUsername(), authUser.getPassword(),
                    authUser.getEnabled(), authUser.getAccountNonExpired(), authUser.getCredentialsNonExpired(),
                    authUser.getAccountNonLocked(), convertToSpringAuthorities(authUser.getAuthorities()));
        } else if (authClientOptional.isPresent()) {
            AuthClient authUser = authClientOptional.get();
                return new org.springframework.security.core.userdetails.User(authUser.getUsername(), authUser.getPassword(),
                    authUser.getEnabled(), authUser.getAccountNonExpired(), authUser.getCredentialsNonExpired(),
                    authUser.getAccountNonLocked(), convertToSpringAuthorities(authUser.getAuthorities()));
        }
        else
            throw new UsernameNotFoundException("User with username: " + username + " not found");
    }

    private Collection<? extends GrantedAuthority> convertToSpringAuthorities(Set<Authority> authorities){
        if (authorities != null && authorities.size() > 0)
            return authorities.stream()
                    .map(Authority::getAuthority)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        return new HashSet<>();
    }
}
