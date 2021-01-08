package com.vsu.drunker.web.bean.controller.tea;

import com.vsu.drunker.web.bean.servise.tea.KindTeaService;
import com.vsu.drunker.web.bean.servise.user.RoleService;
import com.vsu.drunker.web.data.KindTeaDTO;
import com.vsu.drunker.web.data.RoleDTO;
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
        value = "Контроллер для работы с видом чая", produces = "Evgeny Popov"
)
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/kind/tea")
public class KindTeaController {

    private final KindTeaService kindTeaService;

    @ApiOperation(value = "Возвращает список всех видов чая")
    @GetMapping("/getAllKindTea")
    public ResponseEntity<Object> getAllSortTea(){
        return new ResponseEntity<>(kindTeaService.getAllKindTea(), HttpStatus.OK);
    }

    @ApiOperation(value = "Вернуть сорт чая по id")
    @GetMapping("/{idKindTea}")
    public ResponseEntity<Object> getKindTea(@ApiParam(value = "Id") @PathVariable Long idKindTea){
        if (!kindTeaService.existByIdKindTeaDTO(idKindTea)){
            return new ResponseEntity<>(new NotFoundDTO(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(kindTeaService.getByIdKindTeaDTO(idKindTea), HttpStatus.OK);
    }

    @ApiOperation(value = "Создать вид чая")
    @PostMapping
    public ResponseEntity<Object> createSortTea(KindTeaDTO kindTeaDTO){
        BadRequestDTO badRequestDTO = ValidationUtils.validationObject(kindTeaDTO, Create.class);

        if (badRequestDTO != null) {
            return new ResponseEntity<>(badRequestDTO, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(kindTeaService.createKindTea(kindTeaDTO), HttpStatus.OK);
    }
}
