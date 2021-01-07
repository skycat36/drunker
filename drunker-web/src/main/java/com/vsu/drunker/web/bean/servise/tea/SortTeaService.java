package com.vsu.drunker.web.bean.servise.tea;

import com.vsu.drunker.db.model.entity.SortTea;
import com.vsu.drunker.db.model.repository.SortTeaRepository;
import com.vsu.drunker.web.bean.converter.SortTeaConverter;
import com.vsu.drunker.web.data.SortTeaDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class SortTeaService {

    private final SortTeaRepository sortTeaRepository;
    private final SortTeaConverter sortTeaConverter;

    @Transactional
    public SortTeaDTO createSortTea(SortTeaDTO sortTeaDTO, Long idKindTea){

        SortTea sortTea = sortTeaConverter.convert(sortTeaDTO);
        sortTea.setKindId(idKindTea);
        return sortTeaConverter.convert(sortTeaRepository.save(sortTea));
    }

    @Transactional
    public SortTeaDTO updateSortTea(Long sortTeaId, SortTeaDTO sortTeaDTO){
        return sortTeaConverter.convert(sortTeaRepository.save(sortTeaConverter.convert(sortTeaId, sortTeaDTO)));
    }

    @Transactional
    public boolean deleteSortTea(Long teaId){
        if (existByIdSortTeaDTO(teaId)){
            sortTeaRepository.deleteById(teaId);
            return true;
        }
        return false;
    }

    public boolean existByIdSortTeaDTO(Long id){
        return sortTeaRepository.existsById(id);
    }

    public SortTeaDTO getByIdSortTeaDTO(Long id){
        return sortTeaConverter.convert(sortTeaRepository.findById(id).orElse(null));
    }

    public List<SortTeaDTO> getAllSortTea(){
        return sortTeaRepository.findAll().stream().map(sortTeaConverter::convert).collect(Collectors.toList());
    }
}
