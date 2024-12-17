package org.youcode.e_banking_security.appUser.DTOs;

import jakarta.validation.constraints.NotNull;

public record UpdatePwDTO(@NotNull String oldPw ,@NotNull String newPw){
}
