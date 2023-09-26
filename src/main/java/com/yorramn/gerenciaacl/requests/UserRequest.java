package com.yorramn.gerenciaacl.requests;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.UniqueElements;

public class UserRequest {
    @NotBlank
    @NotEmpty
    @NotNull
    @Size(max = 255)
    private String name;
    @NotBlank
    @NotEmpty
    @NotNull
    @Size(max = 50)
    @Email
    @UniqueElements
    private String email;
    @NotBlank
    @NotEmpty
    @NotNull
    @Size(max = 255, min = 3)
    private String password;
}
