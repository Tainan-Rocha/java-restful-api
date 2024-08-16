package edu.projeto.java_api.service;

import org.springframework.stereotype.Service;

import edu.projeto.java_api.domain.model.User;
import edu.projeto.java_api.domain.repository.UserRepository;

import java.lang.IllegalArgumentException;
import java.util.NoSuchElementException;

@Service
public class UserServiceImplementation implements UserService{
    
    // Responsible for interaction with the database
    private final UserRepository userRepository;

    // Construtor 
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Methods

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exist.");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public User findByID(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
