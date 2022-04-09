package ru.iteco.account.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    Integer id;
    String name;
    String email;
}
