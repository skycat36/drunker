package com.vsu.drunker.web.data;

import com.vsu.drunker.web.validation.group.Create;
import com.vsu.drunker.web.validation.group.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ApiModel(value = "UserDTO", description = "Пользователь")
public class UserDTO {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "ФИО", required = true)
    @NotBlank(message = "FIO can't be empty", groups = {Create.class, Update.class})
    private String fio;

    @ApiModelProperty(value = "Login", required = true)
    @NotBlank(message = "Login can't be empty", groups = {Create.class, Update.class})
    private String login;

    @ApiModelProperty(value = "Пароль")
    private String password;

    @ApiModelProperty(value = "Номер телефона", required = true)
    @NotBlank(message = "Phone can't be empty", groups = {Create.class, Update.class})
    private String phone;

    @ApiModelProperty(value = "Email", required = true)
    @NotBlank(message = "Email can't be empty", groups = {Create.class, Update.class})
    private String email;

    @ApiModelProperty(value = "Права")
    @lombok.NonNull
    private RoleDTO roleDTO;
}
