package org.youcode.e_banking_security.common.utils;

public interface BaseMapper <T , DTO>{
    T toEntity(DTO dto);
    DTO entityToDto(T entity);
}
