package ru.iteco.account.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class User {

    private Integer id;
    private String name;
}
