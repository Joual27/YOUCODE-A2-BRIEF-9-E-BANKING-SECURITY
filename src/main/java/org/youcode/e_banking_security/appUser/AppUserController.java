package org.youcode.e_banking_security.appUser;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.youcode.e_banking_security.appUser.DTOs.AppUserResponseDTO;
import org.youcode.e_banking_security.appUser.DTOs.CreateAppUserDTO;
import org.youcode.e_banking_security.appUser.DTOs.UpdatePwDTO;
import org.youcode.e_banking_security.appUser.interfaces.AppUserService;
import org.youcode.e_banking_security.common.utils.DTOs.SuccessDTO;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/register")
    public ResponseEntity<SuccessDTO<AppUserResponseDTO>> register(@RequestBody @Valid CreateAppUserDTO req){
        AppUserResponseDTO res = appUserService.save(req);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "user created successfully !" , res) , HttpStatus.CREATED);
    }

    @PutMapping("/{username}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<SuccessDTO<AppUserResponseDTO>> register(@RequestBody @Valid UpdatePwDTO req , @PathVariable("username") String username , Authentication authentication){
        AppUserResponseDTO res = appUserService.updatePw(req , username , authentication);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "user pw updated successfully !" , res) , HttpStatus.CREATED);
    }
}
