package com.vsu.drunker.web.bean.controller.user;

import com.vsu.drunker.web.bean.servise.user.RoleService;
import com.vsu.drunker.web.data.RoleDTO;
import com.vsu.drunker.web.data.errors.BadRequestDTO;
import com.vsu.drunker.web.data.errors.NotFoundDTO;
import com.vsu.drunker.web.validation.ValidationUtils;
import com.vsu.drunker.web.validation.group.Create;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(
        value = "Information about role", produces = "Evgeny Popov"
)
@Slf4j
@AllArgsConstructor
@RestController
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/api/role")
    public ResponseEntity<Object> createRole(RoleDTO roleDTO){
        BadRequestDTO badRequestDTO = ValidationUtils.validationObject(roleDTO, Create.class);

        if (badRequestDTO != null) {
            return new ResponseEntity<>(badRequestDTO, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(roleService.createRole(roleDTO), HttpStatus.OK);
    }

    @PutMapping("/api/role/{id}")
    public ResponseEntity<Object> updateRole(@PathVariable Long id, RoleDTO roleDTO){
        BadRequestDTO badRequestDTO = ValidationUtils.validationObject(roleDTO, Create.class);

        if (badRequestDTO != null) {
            return new ResponseEntity<>(badRequestDTO, HttpStatus.BAD_REQUEST);
        }
        if (!roleService.existByIdRoleDTO(id)){
            return new ResponseEntity<>(new NotFoundDTO(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(roleService.updateRole(id, roleDTO), HttpStatus.OK);
    }

    @DeleteMapping("/api/role/{id}")
    public ResponseEntity<Object> deleteRoles(@PathVariable Long id){
        if (roleService.deleteRole(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/api/getAllRoles")
    public ResponseEntity<Object> getAllRoles(){
        return new ResponseEntity<>(roleService.getAllRoleDTO(), HttpStatus.OK);
    }


}
