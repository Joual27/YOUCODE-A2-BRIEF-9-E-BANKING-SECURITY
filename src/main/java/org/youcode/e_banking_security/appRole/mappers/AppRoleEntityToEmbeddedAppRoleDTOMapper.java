package org.youcode.e_banking_security.appRole.mappers;

import org.mapstruct.Mapper;
import org.youcode.e_banking_security.appRole.AppRole;
import org.youcode.e_banking_security.appRole.DTOs.EmbeddedAppRoleDTO;
import org.youcode.e_banking_security.common.utils.BaseMapper;

@Mapper(componentModel = "spring")
public interface AppRoleEntityToEmbeddedAppRoleDTOMapper extends BaseMapper<AppRole , EmbeddedAppRoleDTO> {
}
