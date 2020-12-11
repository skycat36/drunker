package com.vsu.drunker.web.data.errors;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NotFoundDTO {

    private Integer status;

    private String message;

    public NotFoundDTO() {
        this.status = 404;
        this.message = "No message available";
    }

}
