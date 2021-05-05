package com.practice19.services;

import com.practice19.models.entities.User;
import com.practice19.models.repositories.UserRepo;
import com.practice19.security.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {

    @Mock
    UserRepo userRepo;

    @Captor
    private ArgumentCaptor<User> argumentCaptor;

    @Test
    void addNewUser() {
        User user = new User();
        user.setEmail("asrr@mail.com");
        user.setPassword("asrr");
        user.setFirst_name("asrr");
        user.setLast_name("asrr");

        UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl(userRepo);
        userDetailsService.addNewUser(user);
        Mockito.verify(userRepo).save(argumentCaptor.capture());
        User captured = argumentCaptor.getValue();
        assertEquals("asrr@mail.com", captured.getEmail());
    }

    @Test
    void userExists() {
        UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl(userRepo);
        Boolean exist = userDetailsService.userExists("kimoror");
        assertEquals(exist, false);
    }
}