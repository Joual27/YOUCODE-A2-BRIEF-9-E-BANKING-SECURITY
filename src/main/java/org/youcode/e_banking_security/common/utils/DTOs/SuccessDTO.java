package org.youcode.e_banking_security.common.utils.DTOs;

public record SuccessDTO<T>(String status , String message , T data) {
}