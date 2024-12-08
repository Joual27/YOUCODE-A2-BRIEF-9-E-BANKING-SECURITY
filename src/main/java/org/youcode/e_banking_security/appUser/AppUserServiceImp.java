package org.youcode.e_banking_security.appUser;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.youcode.e_banking_security.appUser.DTOs.AppUserResponseDTO;
import org.youcode.e_banking_security.appUser.DTOs.CreateAppUserDTO;
import org.youcode.e_banking_security.appUser.interfaces.AppUserService;

@AllArgsConstructor
@Service
public class AppUserServiceImp implements AppUserService {
    private final AppUserDAO appUserDAO;

//    public AppUserResponseDTO save(CreateAppUserDTO data){
//
//    }
}
