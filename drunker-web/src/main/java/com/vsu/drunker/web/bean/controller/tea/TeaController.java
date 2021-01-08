package com.vsu.drunker.web.bean.controller.tea;

import com.vsu.drunker.web.bean.servise.tea.TeaService;
import com.vsu.drunker.web.data.TeaDTO;
import com.vsu.drunker.web.data.errors.BadRequestDTO;
import com.vsu.drunker.web.data.errors.NotFoundDTO;
import com.vsu.drunker.web.data.tea.TeaFilterDTO;
import com.vsu.drunker.web.validation.ValidationUtils;
import com.vsu.drunker.web.validation.group.Create;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(
        value = "Контроллер для работы с чаем", produces = "Evgeny Popov"
)
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tea")
public class TeaController {

    private final TeaService teaService;

    @ApiOperation(value = "Возвращает список чаев по заданному фильтру")
    @GetMapping("/getTeaByFilter")
    public ResponseEntity<Object> getTeaList(@RequestBody TeaFilterDTO teaFilterDTO){
        return new ResponseEntity<>(teaService.getTeaByFilter(teaFilterDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Возвращает  чай по id")
    @GetMapping("/{idTea}")
    public ResponseEntity<Object> getTeaById(@ApiParam(value = "Id") @PathVariable Long idTea){
        return new ResponseEntity<>(teaService.getTeaById(idTea), HttpStatus.OK);
    }

    @ApiOperation(value = "Создать чай")
    @PostMapping
    public ResponseEntity<Object> createTea(@RequestBody TeaDTO teaDTO){
        BadRequestDTO badRequestDTO = ValidationUtils.validationObject(teaDTO, Create.class);

        if (badRequestDTO != null) {
            return new ResponseEntity<>(badRequestDTO, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(teaService.createTea(teaDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Обновить информацию о чае")
    @PutMapping("/{idTea}")
    public ResponseEntity<Object> updateTea(@ApiParam(value = "Id") @PathVariable Long idTea, @RequestBody TeaDTO teaDTO){
        BadRequestDTO badRequestDTO = ValidationUtils.validationObject(teaDTO, Create.class);

        if (badRequestDTO != null) {
            return new ResponseEntity<>(badRequestDTO, HttpStatus.BAD_REQUEST);
        }

        if (!teaService.existByIdTeaDTO(idTea)){
            return new ResponseEntity<>(new NotFoundDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teaService.updateTea(idTea, teaDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Удалить сорт чая")
    @DeleteMapping("/{idTea}")
    public ResponseEntity<Object> deleteRoles(@ApiParam(value = "Id") @PathVariable Long idTea){
        if (!teaService.existByIdTeaDTO(idTea)){
            return new ResponseEntity<>(new NotFoundDTO(), HttpStatus.NOT_FOUND);
        }

        if (teaService.deleteTea(idTea)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
