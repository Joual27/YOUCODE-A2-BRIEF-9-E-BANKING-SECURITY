package org.youcode.e_banking_security.appUser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.youcode.e_banking_security.appRole.AppRole;
import org.youcode.e_banking_security.appUser.DTOs.AppUserResponseDTO;
import org.youcode.e_banking_security.appUser.DTOs.CreateAppUserDTO;
import org.youcode.e_banking_security.appUser.DTOs.UpdatePwDTO;
import org.youcode.e_banking_security.appUser.interfaces.AppUserService;
import org.youcode.e_banking_security.appUser.mappers.AppUserEntityToAppUserResponseDTOMapper;
import org.youcode.e_banking_security.appUser.mappers.CreateAppUserDTOToAppUserEntityMapper;
import org.youcode.e_banking_security.common.exceptions.EntityNotFoundException;
import org.youcode.e_banking_security.common.exceptions.IncorrectOldPwException;
import org.youcode.e_banking_security.common.exceptions.UnauthorizedUpdateException;
import org.youcode.e_banking_security.common.exceptions.UsernameAlreadyExistsException;

@Service
@AllArgsConstructor
public class AppUserServiceImp implements AppUserService {
    private final AppUserDAO appUserDAO;
    private final PasswordEncoder passwordEncoder;
    private final AppUserEntityToAppUserResponseDTOMapper appUserEntityToAppUserResponseDTOMapper;
    private final CreateAppUserDTOToAppUserEntityMapper createAppUserDTOToAppUserEntityMapper;


    @Override
    public AppUserResponseDTO save(CreateAppUserDTO data){
       if (appUserDAO.findByUsername(data.username()).isPresent()){
           throw new UsernameAlreadyExistsException("Username already used ! try Another one !");
       }
       AppUser userToCreate = createAppUserDTOToAppUserEntityMapper.toEntity(data);
       userToCreate.setPassword(passwordEncoder.encode(data.password()));
       AppRole role = new AppRole();
       role.setId(2L);
       role.setName("ROLE_USER");
       userToCreate.setRole(role);
       appUserDAO.save(userToCreate);
       return appUserEntityToAppUserResponseDTOMapper.entityToDto(userToCreate);
    }

    @Override
    public AppUserResponseDTO updatePw(UpdatePwDTO data , String username , Authentication authentication){
        if (!username.equals(authentication.getName())){
            throw new UnauthorizedUpdateException("Sorry , You can't update other users credentials !");
        }
        AppUser user = appUserDAO.findByUsername(username)
                .orElseThrow( () -> new EntityNotFoundException("NO user found with given Username"));
        if (!passwordEncoder.matches(data.oldPw(), user.getPassword())){
            throw new IncorrectOldPwException("The given old password is incorrect !");
        }
        user.setPassword(passwordEncoder.encode(data.newPw()));
        appUserDAO.save(user);
        return appUserEntityToAppUserResponseDTOMapper.entityToDto(user);
    }
}
