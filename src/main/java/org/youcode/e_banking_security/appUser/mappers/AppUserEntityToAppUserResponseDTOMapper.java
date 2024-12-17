package org.youcode.e_banking_security.appUser.mappers;

import org.mapstruct.Mapper;
import org.youcode.e_banking_security.appRole.mappers.AppRoleEntityToEmbeddedAppRoleDTOMapper;
import org.youcode.e_banking_security.appUser.AppUser;
import org.youcode.e_banking_security.appUser.DTOs.AppUserResponseDTO;
import org.youcode.e_banking_security.common.utils.BaseMapper;

@Mapper(componentModel = "spring" , uses = AppRoleEntityToEmbeddedAppRoleDTOMapper.class)
public interface AppUserEntityToAppUserResponseDTOMapper extends BaseMapper<AppUser, AppUserResponseDTO> {
}
