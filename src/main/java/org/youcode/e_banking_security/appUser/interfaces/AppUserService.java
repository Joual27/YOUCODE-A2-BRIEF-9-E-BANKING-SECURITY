package org.youcode.e_banking_security.appUser.interfaces;

import org.springframework.security.core.Authentication;
import org.youcode.e_banking_security.appUser.DTOs.AppUserResponseDTO;
import org.youcode.e_banking_security.appUser.DTOs.CreateAppUserDTO;
import org.youcode.e_banking_security.appUser.DTOs.UpdatePwDTO;

public interface AppUserService {
    AppUserResponseDTO save(CreateAppUserDTO data);
    AppUserResponseDTO updatePw(UpdatePwDTO data , String username , Authentication authentication);
}
