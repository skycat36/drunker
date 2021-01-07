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
@ApiModel(value = "Роль пользователя")
public class RoleDTO {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "Название роли")
    @NotBlank(message = "Name can't be empty", groups = {Create.class, Update.class})
    private String name;
}
