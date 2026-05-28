package com.igorpolvora.workshopmongo.services;

import org.springframework.stereotype.Service;
import com.igorpolvora.workshopmongo.domain.User;
import com.igorpolvora.workshopmongo.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
