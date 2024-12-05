package org.youcode.e_banking_security.appUser;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.youcode.e_banking_security.appRole.AppRole;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private AppRole role;


}
