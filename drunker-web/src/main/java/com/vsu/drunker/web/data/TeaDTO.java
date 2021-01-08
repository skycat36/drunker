package com.vsu.drunker.web.data;

import com.vsu.drunker.web.validation.group.Create;
import com.vsu.drunker.web.validation.group.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ApiModel(value = "TeaDTO", description = "Чай")
public class TeaDTO {

    @ApiModelProperty(value = "Id")
    @lombok.NonNull
    private Long id;

    @ApiModelProperty(value = "Название чая")
    @NotBlank(message = "Name can't be empty", groups = {Create.class, Update.class})
    @lombok.NonNull
    private String name;

    @ApiModelProperty(value = "Количество на складе")
    @Negative(message = "Name can't be empty or less zero", groups = {Create.class, Update.class})
    @lombok.NonNull
    private Integer countOnWarehouse;

    @ApiModelProperty(value = "Сорт чая")
    private SortTeaDTO sortTeaDTO;
}
