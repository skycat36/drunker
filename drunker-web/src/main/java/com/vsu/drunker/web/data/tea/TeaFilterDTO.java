package com.vsu.drunker.web.data.tea;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "TeaFilterDTO", description = "Фильтр для поиска чаев")
public class TeaFilterDTO {

    @ApiModelProperty(value = "Фильтр сортов чая")
    List<Long> listSorts;

    @ApiModelProperty(value = "Фильтр видов чая")
    List<Long> listKinds;
}
