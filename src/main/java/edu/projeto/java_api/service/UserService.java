package edu.projeto.java_api.service;

import edu.projeto.java_api.domain.model.User;

public interface UserService {

    User findByID(Long id);

    User create (User userToCreate);
    
}
