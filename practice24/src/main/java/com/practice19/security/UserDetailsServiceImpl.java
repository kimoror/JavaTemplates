package com.practice19.security;


import com.practice19.exceptions.UserAlreadyExistsException;
import com.practice19.models.entities.User;
import com.practice19.models.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exists"));
        return SecurityUser.fromUser(user);
    }

    public void addNewUser(User user) throws UserAlreadyExistsException{
        if(userExists(user.getEmail())){
            throw new UserAlreadyExistsException(user.getEmail());
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepo.save(user);
    }

    @Transactional
    public boolean userExists(String userEmail){
        return userRepo.findByEmail(userEmail).isPresent();
    }
}
