package org.youcode.e_banking_security.appUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserDAO extends JpaRepository<AppUser , Long> {
    Optional<AppUser> findByUsername(String username);
}