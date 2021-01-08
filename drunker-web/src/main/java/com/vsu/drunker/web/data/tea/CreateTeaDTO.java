package com.vsu.drunker.web.data.tea;

import com.vsu.drunker.web.validation.group.Create;
import com.vsu.drunker.web.validation.group.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ApiModel(value = "CreateTeaDTO", description = "Создать Чай")
public class CreateTeaDTO {

    @ApiModelProperty(value = "Название чая", required = true)
    @NotBlank(message = "Name can't be empty", groups = {Create.class, Update.class})
    @lombok.NonNull
    private String name;

    @ApiModelProperty(value = "Количество на складе", required = true)
    @PositiveOrZero(message = "Count on warehouse can't be empty or less zero", groups = {Create.class, Update.class})
    @lombok.NonNull
    private Integer countOnWarehouse;

    @ApiModelProperty(value = "Сорт чая")
    @NotNull(message = "Sort tea can't be empty", groups = {Create.class, Update.class})
    @lombok.NonNull
    private Long sortTeaId;

    @ApiModelProperty(value = "Вид чая")
    @NotNull(message = "Kind tea can't be empty", groups = {Create.class, Update.class})
    @lombok.NonNull
    private Long kindTeaId;
}
