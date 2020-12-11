package com.vsu.drunker.web.bean.user;

import com.vsu.drunker.db.model.entity.Role;
import com.vsu.drunker.db.model.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @PostMapping("/api/role")
    public ResponseEntity<Object> createRole(){
//        BadRequestDTO badRequestDTO = ValidationUtils.validationObject(roleDTO, Create.class);
//
//        if (badRequestDTO != null) {
//            return new ResponseEntity<>(badRequestDTO, HttpStatus.BAD_REQUEST);
//        }
        return new ResponseEntity<>(roleRepository.save(new Role(null, "test123")), HttpStatus.OK);
    }


}
