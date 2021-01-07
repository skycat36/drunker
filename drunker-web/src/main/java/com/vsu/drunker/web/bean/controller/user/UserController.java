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

@Api(
        value = "Контроллер для работы с пользователями", produces = "Evgeny Popov"
)
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final FileControllerApi fileControllerApi;

    @ApiOperation(value = "Создать пользователя")
    @PostMapping
    public ResponseEntity<Object> createUser(@ApiParam(
            value = "User data") @RequestBody UserDTO userDTO){
        BadRequestDTO badRequestDTO = ValidationUtils.validationObject(userDTO, Create.class);

        if (badRequestDTO != null) {
            return new ResponseEntity<>(badRequestDTO, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Обновить пользователя")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id,
                                             @ApiParam(value = "User data") @RequestBody UserDTO userDTO){
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
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id){
        if (userService.deleteUser(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Вернуть всех пользователей")
    @GetMapping("/getAllUser")
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUserDTO(), HttpStatus.OK);
    }

}
