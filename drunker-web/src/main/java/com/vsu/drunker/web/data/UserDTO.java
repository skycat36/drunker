package com.vsu.drunker.web.data;

import com.vsu.drunker.web.validation.group.Create;
import com.vsu.drunker.web.validation.group.Update;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank(message = "FIO can't be empty", groups = {Create.class, Update.class})
    private String fio;

    @NotBlank(message = "Login can't be empty", groups = {Create.class, Update.class})
    private String login;

    private String password;

    @NotBlank(message = "Phone can't be empty", groups = {Create.class, Update.class})
    private String phone;

    @NotBlank(message = "Email can't be empty", groups = {Create.class, Update.class})
    private String email;
}
