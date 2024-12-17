package org.youcode.e_banking_security.admin;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.youcode.e_banking_security.admin.utils.AdminService;
import org.youcode.e_banking_security.appRole.AppRole;
import org.youcode.e_banking_security.appUser.AppUser;
import org.youcode.e_banking_security.appUser.AppUserDAO;
import org.youcode.e_banking_security.appUser.DTOs.AppUserResponseDTO;
import org.youcode.e_banking_security.appUser.mappers.AppUserEntityToAppUserResponseDTOMapper;
import org.youcode.e_banking_security.common.exceptions.EntityNotFoundException;

import javax.management.relation.Role;

@AllArgsConstructor
@Service
public class AdminServiceImp implements AdminService {
    private final AppUserDAO appUserDAO;
    private final AppUserEntityToAppUserResponseDTOMapper appUserEntityToAppUserResponseDTOMapper;


    @Override
    public Page<AppUserResponseDTO> getAllUsers(Pageable pageable){
        Page<AppUser> res = appUserDAO.findAll(pageable);
        return res.map(appUserEntityToAppUserResponseDTOMapper::entityToDto);
    }

    @Override
    public AppUserResponseDTO getUserByUsername(String username){
        AppUser user = appUserDAO.findByUsername(username)
                .orElseThrow(()-> new EntityNotFoundException("No user found with given Username"));
        return appUserEntityToAppUserResponseDTOMapper.entityToDto(user);
    }

    @Override
    public AppUserResponseDTO delete(String username){
        AppUser user = appUserDAO.findByUsername(username)
                .orElseThrow(()-> new EntityNotFoundException("No user found with given Username"));
        appUserDAO.deleteByUsername(username);
        return appUserEntityToAppUserResponseDTOMapper.entityToDto(user);
    }

    @Override
    public AppUserResponseDTO updateRole(String username){
        AppUser user = appUserDAO.findByUsername(username)
                .orElseThrow(()-> new EntityNotFoundException("No user found with given Username"));
        AppRole role = new AppRole();
        role.setId(1L);
        role.setName("ROLE_ADMIN");
        user.setRole(role);
        appUserDAO.save(user);
        return appUserEntityToAppUserResponseDTOMapper.entityToDto(user);
    }

}
