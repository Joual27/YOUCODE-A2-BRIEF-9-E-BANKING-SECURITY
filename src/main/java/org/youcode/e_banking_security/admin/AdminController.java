package org.youcode.e_banking_security.admin;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.youcode.e_banking_security.admin.utils.AdminService;
import org.youcode.e_banking_security.appUser.DTOs.AppUserResponseDTO;
import org.youcode.e_banking_security.common.utils.DTOs.SuccessDTO;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;
    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<SuccessDTO<List<AppUserResponseDTO>>> getAllUsers(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<AppUserResponseDTO> res = adminService.getAllUsers(pageRequest);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "users retrieved successfully !" , res.getContent()) , HttpStatus.OK);
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<SuccessDTO<AppUserResponseDTO>> getUserByUsername(@PathVariable("username") String username){
        AppUserResponseDTO res = adminService.getUserByUsername(username);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "user retrieved successfully !" , res) , HttpStatus.OK);
    }
    @DeleteMapping("/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<SuccessDTO<AppUserResponseDTO>> delete(@PathVariable("username") String username){
        AppUserResponseDTO res = adminService.delete(username);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "user deleted successfully !" , res) , HttpStatus.OK);
    }

    @PutMapping("/{username}/updateRole")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<SuccessDTO<AppUserResponseDTO>> updateRole(@PathVariable("username") String username){
        AppUserResponseDTO res = adminService.updateRole(username);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "user role updated successfully !" , res) , HttpStatus.OK);
    }
}
