package com.vsu.drunker.web.bean.controller.user;

import com.vsu.drunker.web.bean.servise.user.RoleService;
import com.vsu.drunker.web.data.RoleDTO;
import com.vsu.drunker.web.data.errors.BadRequestDTO;
import com.vsu.drunker.web.data.errors.NotFoundDTO;
import com.vsu.drunker.web.validation.ValidationUtils;
import com.vsu.drunker.web.validation.group.Create;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(
        value = "Контроллер для работы с ролями", produces = "Evgeny Popov"
)
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/role")
public class RoleController {

    private final RoleService roleService;

    @ApiOperation(value = "Создать роль")
    @PostMapping
    public ResponseEntity<Object> createRole(@ApiParam(value = "Новая роль") @RequestBody RoleDTO roleDTO){
        BadRequestDTO badRequestDTO = ValidationUtils.validationObject(roleDTO, Create.class);

        if (badRequestDTO != null) {
            return new ResponseEntity<>(badRequestDTO, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(roleService.createRole(roleDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Изменить роль")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRole(@ApiParam(value = "Id") @PathVariable Long id,
                                             @ApiParam(value = "Обновленная роль") @RequestBody RoleDTO roleDTO){
        BadRequestDTO badRequestDTO = ValidationUtils.validationObject(roleDTO, Create.class);

        if (badRequestDTO != null) {
            return new ResponseEntity<>(badRequestDTO, HttpStatus.BAD_REQUEST);
        }
        if (!roleService.existByIdRoleDTO(id)){
            return new ResponseEntity<>(new NotFoundDTO(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(roleService.updateRole(id, roleDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Удалить роль")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRoles(@ApiParam(value = "Id") @PathVariable Long id){
        if (roleService.deleteRole(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Возвращает список всех ролей")
    @GetMapping("/getAllRoles")
    public ResponseEntity<Object> getAllRoles(){
        return new ResponseEntity<>(roleService.getAllRoleDTO(), HttpStatus.OK);
    }


}
