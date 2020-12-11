package com.vsu.drunker.web.data;


import com.vsu.drunker.web.validation.group.Create;
import com.vsu.drunker.web.validation.group.Update;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class KindTeaDTO {

    private Long id;

    @NotBlank(message = "Name can't be empty", groups = {Create.class, Update.class})
    private String name;
}
