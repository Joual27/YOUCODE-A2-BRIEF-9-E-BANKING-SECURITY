package org.youcode.e_banking_security.security.utils;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.youcode.e_banking_security.appUser.AppUser;
import org.youcode.e_banking_security.appUser.AppUserDAO;

import java.util.Collections;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AppUserDAO appUserDAO;

    @Override
    public UserDetails loadUserByUsername(String username){
        AppUser user = appUserDAO.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user was found with given Username"));
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());
        return new User(user.getUsername() , user.getPassword() , Collections.singletonList(authority));
    }
}
