package com.vsu.drunker.web.bean.servise.tea;

import com.vsu.drunker.db.model.repository.TeaRepository;
import com.vsu.drunker.web.bean.converter.TeaConverter;
import com.vsu.drunker.web.data.TeaDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class TeaService {

    private final TeaRepository teaRepository;
    private final TeaConverter teaConverter;

    @Transactional
    public TeaDTO createRole(TeaDTO roleDTO){
        return teaConverter.convert(teaRepository.save(teaConverter.convert(roleDTO)));
    }

    @Transactional
    public TeaDTO updateRole(Long teaId, TeaDTO roleDTO){
        return teaConverter.convert(teaRepository.save(teaConverter.convert(teaId, roleDTO)));
    }

    @Transactional
    public boolean deleteRole(Long teaId){
        if (existByIdTeaDTO(teaId)){
            teaRepository.deleteById(teaId);
            return true;
        }
        return false;
    }

    public boolean existByIdTeaDTO(Long id){
        return teaRepository.existsById(id);
    }

    public List<TeaDTO> getAllTeaDTO(){
        return teaRepository.findAll().stream().map(teaConverter::convert).collect(Collectors.toList());
    }
}
