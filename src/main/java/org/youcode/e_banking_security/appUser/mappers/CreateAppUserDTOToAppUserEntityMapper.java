package org.youcode.e_banking_security.appUser.mappers;

import org.mapstruct.Mapper;
import org.youcode.e_banking_security.appUser.AppUser;
import org.youcode.e_banking_security.appUser.DTOs.CreateAppUserDTO;
import org.youcode.e_banking_security.common.utils.BaseMapper;

@Mapper(componentModel = "spring")
public interface CreateAppUserDTOToAppUserEntityMapper extends BaseMapper<AppUser , CreateAppUserDTO> {
}
