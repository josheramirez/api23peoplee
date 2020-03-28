package net.api.apiJava8.service.jpa;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.api.apiJava8.entity.Course;
import net.api.apiJava8.entity.User;
import net.api.apiJava8.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println("aqui en CustomUserDetailService");
    	
//    	System.out.println( new org.springframework.security.core.userdetails.User("invite_user", "invite_user", new ArrayList<>()));
//    	User user = repository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User("invite_user", "invite_user", new ArrayList<>());
    }

}