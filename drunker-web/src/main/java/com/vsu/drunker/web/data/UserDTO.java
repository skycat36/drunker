package com.vsu.drunker.web.data;

import com.vsu.drunker.web.validation.group.Create;
import com.vsu.drunker.web.validation.group.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Пользователь")
public class UserDTO {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "ФИО")
    @NotBlank(message = "FIO can't be empty", groups = {Create.class, Update.class})
    private String fio;

    @ApiModelProperty(value = "Login")
    @NotBlank(message = "Login can't be empty", groups = {Create.class, Update.class})
    private String login;

    @ApiModelProperty(value = "Пароль")
    private String password;

    @ApiModelProperty(value = "Номер телефона")
    @NotBlank(message = "Phone can't be empty", groups = {Create.class, Update.class})
    private String phone;

    @ApiModelProperty(value = "Email")
    @NotBlank(message = "Email can't be empty", groups = {Create.class, Update.class})
    private String email;

    @ApiModelProperty(value = "Права")
    private RoleDTO roleDTO;
}
