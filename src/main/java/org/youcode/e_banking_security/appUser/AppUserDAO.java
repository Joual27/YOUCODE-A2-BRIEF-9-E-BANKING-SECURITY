package org.youcode.e_banking_security.appUser;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserDAO extends JpaRepository<AppUser , Long> {
    Optional<AppUser> findByUsername(String username);

    @Transactional
    @Modifying
    @Query("DELETE FROM AppUser a WHERE a.username = :username")
    void deleteByUsername(@Param("username") String username);

}
