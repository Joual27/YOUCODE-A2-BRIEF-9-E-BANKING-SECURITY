package org.youcode.e_banking_security.admin.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.youcode.e_banking_security.appUser.DTOs.AppUserResponseDTO;

public interface AdminService {
    Page<AppUserResponseDTO> getAllUsers(Pageable pageable);
    AppUserResponseDTO getUserByUsername(String username);
    AppUserResponseDTO delete(String username);
    AppUserResponseDTO updateRole(String username);
}
