package com.vsu.drunker.web.bean.controller.tea;

import com.vsu.drunker.web.bean.servise.tea.KindTeaService;
import com.vsu.drunker.web.bean.servise.tea.SortTeaService;
import com.vsu.drunker.web.data.SortTeaDTO;
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
        value = "Контроллер для работы с сортом чая", produces = "Evgeny Popov"
)
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/sort/tea")
public class SortTeaController {

    private final SortTeaService sortTeaService;
    private final KindTeaService kindTeaService;

    @ApiOperation(value = "Возвращает список всех сортов чая")
    @GetMapping("/getAllSortTea")
    public ResponseEntity<Object> getAllSortTea(){
        return new ResponseEntity<>(sortTeaService.getAllSortTea(), HttpStatus.OK);
    }

    @ApiOperation(value = "Вернуть сорт чая по id")
    @GetMapping("/{idSortTea}")
    public ResponseEntity<Object> getSortTea(@PathVariable Long idSortTea){
        if (!sortTeaService.existByIdSortTeaDTO(idSortTea)){
            return new ResponseEntity<>(new NotFoundDTO(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(sortTeaService.getByIdSortTeaDTO(idSortTea), HttpStatus.OK);
    }

    @ApiOperation(value = "Создать сорт чая")
    @PostMapping
    public ResponseEntity<Object> createSortTea(
            @ApiParam(value = "Новый сорт чая") @RequestBody SortTeaDTO sortTeaDTO, @RequestBody Long idKindTea){
        BadRequestDTO badRequestDTO = ValidationUtils.validationObject(sortTeaDTO, Create.class);

        if (!kindTeaService.existByIdKindTeaDTO(idKindTea)){
            return new ResponseEntity<>("Kind tea not exist", HttpStatus.BAD_REQUEST);
        }

        if (badRequestDTO != null) {
            return new ResponseEntity<>(badRequestDTO, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(sortTeaService.createSortTea(sortTeaDTO, idKindTea), HttpStatus.OK);
    }

    @ApiOperation(value = "Изменить сорт чая")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRole(@PathVariable Long id,
                                             @ApiParam(value = "Обновленный сорт чая") @RequestBody SortTeaDTO sortTeaDTO){
        BadRequestDTO badRequestDTO = ValidationUtils.validationObject(sortTeaDTO, Create.class);

        if (badRequestDTO != null) {
            return new ResponseEntity<>(badRequestDTO, HttpStatus.BAD_REQUEST);
        }
        if (!sortTeaService.existByIdSortTeaDTO(id)){
            return new ResponseEntity<>(new NotFoundDTO(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(sortTeaService.updateSortTea(id, sortTeaDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Удалить сорт чая")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRoles(@PathVariable Long id){
        if (!sortTeaService.existByIdSortTeaDTO(id)){
            return new ResponseEntity<>(new NotFoundDTO(), HttpStatus.NOT_FOUND);
        }

        if (sortTeaService.deleteSortTea(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
