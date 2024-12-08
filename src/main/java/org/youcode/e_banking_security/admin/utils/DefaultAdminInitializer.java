package org.youcode.e_banking_security.admin.utils;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.youcode.e_banking_security.appRole.AppRole;
import org.youcode.e_banking_security.appUser.AppUser;
import org.youcode.e_banking_security.appUser.AppUserDAO;


@AllArgsConstructor
@Component
public class DefaultAdminInitializer implements CommandLineRunner {

    private final AppUserDAO appUserDAO;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args){
      if (appUserDAO.findByUsername("admin").isEmpty()){
          AppUser admin = new AppUser();
          AppRole role = new AppRole();
          role.setId(1L);
          role.setName("ROLE_ADMIN");
          admin.setUsername("admin");
          admin.setPassword(passwordEncoder.encode("admin"));
          admin.setRole(role);
          appUserDAO.save(admin);
      }
    }
}
