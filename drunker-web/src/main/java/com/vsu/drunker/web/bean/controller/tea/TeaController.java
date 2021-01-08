package com.vsu.drunker.web.bean.controller.tea;

import com.vsu.drunker.web.data.RoleDTO;
import com.vsu.drunker.web.data.errors.BadRequestDTO;
import com.vsu.drunker.web.validation.ValidationUtils;
import com.vsu.drunker.web.validation.group.Create;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(
        value = "Контроллер для работы с чаем", produces = "Evgeny Popov"
)
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/tea")
public class TeaController {




//    @ApiOperation(value = "Возвращает список всех ролей")
//    @GetMapping("/getAllRoles")
//    public ResponseEntity<Object> getAllRoles(){
//        return new ResponseEntity<>(roleService.getAllRoleDTO(), HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Создать роль")
//    @PostMapping
//    public ResponseEntity<Object> createRole(RoleDTO roleDTO){
//        BadRequestDTO badRequestDTO = ValidationUtils.validationObject(roleDTO, Create.class);
//
//        if (badRequestDTO != null) {
//            return new ResponseEntity<>(badRequestDTO, HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(roleService.createRole(roleDTO), HttpStatus.OK);
//    }

}
