package com.vsu.drunker.web.bean.controller.user;

import com.vsu.drunker.web.bean.client.FileControllerApi;
import com.vsu.drunker.web.bean.servise.user.UserService;
import com.vsu.drunker.web.data.UserDTO;
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

import java.io.IOException;
import java.util.List;

@Api(
        value = "Information about user", produces = "Evgeny Popov"
)
@Slf4j
@AllArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final FileControllerApi fileControllerApi;

    @ApiOperation(value = "Создать пользователя")
    @PostMapping("/api/user")
    public ResponseEntity<Object> createUser(@ApiParam(
            value = "User data") @RequestBody UserDTO userDTO){
        BadRequestDTO badRequestDTO = ValidationUtils.validationObject(userDTO, Create.class);

        if (badRequestDTO != null) {
            return new ResponseEntity<>(badRequestDTO, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Создать пользователя")
    @PutMapping("/api/user/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, UserDTO userDTO){
        BadRequestDTO badRequestDTO = ValidationUtils.validationObject(userDTO, Create.class);

        if (badRequestDTO != null) {
            return new ResponseEntity<>(badRequestDTO, HttpStatus.BAD_REQUEST);
        }
        if (!userService.existByIdUserDTO(id)){
            return new ResponseEntity<>(new NotFoundDTO(), HttpStatus.NOT_FOUND);
        }

        try {
            return new ResponseEntity<>(userService.updateUser(id, userDTO), HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(new BadRequestDTO(), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Удалить пользователя")
    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id){
        if (userService.deleteUser(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Вернуть всех пользователей")
    @GetMapping("/api/getAllUser")
    public ResponseEntity<List<String>> getAllUsers() throws IOException {
//        return new ResponseEntity<>(userService.getAllUserDTO(), HttpStatus.OK);
        return fileControllerApi.getAllObjectNameFromBucket("tea");
    }

}
