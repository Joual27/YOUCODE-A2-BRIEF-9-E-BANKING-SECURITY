package org.youcode.e_banking_security.appUser.DTOs;

import org.youcode.e_banking_security.appRole.DTOs.EmbeddedAppRoleDTO;

public record AppUserResponseDTO(Long id , String username , EmbeddedAppRoleDTO role) {}
