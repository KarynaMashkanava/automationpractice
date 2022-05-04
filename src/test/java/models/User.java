package models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private String email;
    private String password;
}
