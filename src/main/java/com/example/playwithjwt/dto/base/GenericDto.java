package com.example.playwithjwt.dto.base;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class GenericDto implements BaseDto{

    @NotBlank
    Integer id;
}
