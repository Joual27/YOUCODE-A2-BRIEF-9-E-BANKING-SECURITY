package org.youcode.e_banking_security.appUser.DTOs;

import jakarta.validation.constraints.NotNull;

public record CreateAppUserDTO (@NotNull String username , @NotNull String password ) {
}
