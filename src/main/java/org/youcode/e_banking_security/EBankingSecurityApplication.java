package org.youcode.e_banking_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan(basePackages = {""})
public class EBankingSecurityApplication {
	public static void main(String[] args) {
		SpringApplication.run(EBankingSecurityApplication.class, args);
	}
}
