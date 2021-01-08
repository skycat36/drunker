package com.vsu.drunker.web.data.tea;

import com.vsu.drunker.web.data.KindTeaDTO;
import com.vsu.drunker.web.data.SortTeaDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "TeaDTO", description = "Чай")
public class TeaDTO {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "Название чая", required = true)
    private String name;

    @ApiModelProperty(value = "Количество на складе", required = true)
    private Integer countOnWarehouse;

    @ApiModelProperty(value = "Сорт чая")
    private SortTeaDTO sortTeaDTO;

    @ApiModelProperty(value = "Вид чая")
    private KindTeaDTO kindTeaDTO;
}
