package com.vsu.drunker.service.tea;

import com.vsu.drunker.model.repository.TeaRepository;
import com.vsu.drunker.converter.TeaConverter;
import com.vsu.drunker.data.TeaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TeaService {

    private final TeaRepository teaRepository;
    private final TeaConverter teaConverter;

    public TeaService(TeaRepository teaRepository, TeaConverter teaConverter) {
        this.teaRepository = teaRepository;
        this.teaConverter = teaConverter;
    }

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
