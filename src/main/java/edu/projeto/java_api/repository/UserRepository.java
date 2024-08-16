package edu.projeto.java_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.projeto.java_api.domain.model.User;

// Creating repository for interaction with the database
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Method responsible for verifying if account number exists in database
    boolean existsByAccountNumber(String accountNumber);
}
    