package com.vsu.drunker.web.bean.servise.tea;

import com.vsu.drunker.db.model.entity.KindTea;
import com.vsu.drunker.db.model.entity.SortTea;
import com.vsu.drunker.db.model.entity.Tea;
import com.vsu.drunker.db.model.repository.KindTeaRepository;
import com.vsu.drunker.db.model.repository.SortTeaRepository;
import com.vsu.drunker.db.model.repository.TeaRepository;
import com.vsu.drunker.db.model.repository.specification.action.AndFilter;
import com.vsu.drunker.db.model.repository.specification.tea.CustomTeaRepository;
import com.vsu.drunker.web.bean.converter.KindTeaConverter;
import com.vsu.drunker.web.bean.converter.SortTeaConverter;
import com.vsu.drunker.web.bean.converter.TeaConverter;
import com.vsu.drunker.web.data.KindTeaDTO;
import com.vsu.drunker.web.data.SortTeaDTO;
import com.vsu.drunker.web.data.tea.CreateTeaDTO;
import com.vsu.drunker.web.data.tea.TeaDTO;
import com.vsu.drunker.web.data.tea.TeaFilterDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class TeaService {

    private final TeaRepository teaRepository;
    private final SortTeaRepository sortTeaRepository;
    private final KindTeaRepository kindTeaRepository;
    private final CustomTeaRepository customTeaRepository;
    private final TeaConverter teaConverter;
    private final KindTeaConverter kindTeaConverter;
    private final SortTeaConverter sortTeaConverter;


    public List<TeaDTO> getTeaByFilter(TeaFilterDTO teaFilterDTO){
        List<TeaDTO> result = new ArrayList<>();
        Map<Long, SortTeaDTO> sortTeaMap = new HashMap<>();
        Map<Long, KindTeaDTO> kindTeaMap = new HashMap<>();
        if (teaFilterDTO != null) {
            AndFilter<Tea> andFilter = new AndFilter<>();
            if (Objects.nonNull(teaFilterDTO.getListSorts())){
                sortTeaMap = sortTeaRepository.findAllByIdIn(teaFilterDTO.getListSorts()).stream().collect(Collectors.toMap(SortTea::getId, sortTeaConverter::convert));
                andFilter.add(customTeaRepository.inTo(Tea.SORT_TEA_ID, teaFilterDTO.getListSorts()));
            }

            if (Objects.nonNull(teaFilterDTO.getListKinds())){
                kindTeaMap = kindTeaRepository.findAllByIdIn(teaFilterDTO.getListKinds()).stream().collect(Collectors.toMap(KindTea::getId, kindTeaConverter::convert));
                andFilter.add(customTeaRepository.inTo(Tea.KIND_ID, teaFilterDTO.getListKinds()));
            }

            if (!andFilter.isEmpty()){
                result = teaRepository.findAll(andFilter.getSpecification()).stream().map(teaConverter::convert).collect(Collectors.toList());
            }
        } else {
            result = teaRepository.findAll().stream().map(teaConverter::convert).collect(Collectors.toList());
        }

        for (TeaDTO teaDTO : result){
            teaDTO.setKindTeaDTO(kindTeaMap.get(teaDTO.getId()));
            teaDTO.setSortTeaDTO(sortTeaMap.get(teaDTO.getId()));
        }
        return result;
    }

    @Transactional
    public TeaDTO createTea(CreateTeaDTO createTeaDTO){
        return teaConverter.convert(teaRepository.save(teaConverter.convert(createTeaDTO)));
    }

    @Transactional
    public TeaDTO updateTea(Long teaId, TeaDTO teaDTO){
        return teaConverter.convert(teaRepository.save(teaConverter.convert(teaId, teaDTO)));
    }

    @Transactional
    public boolean deleteTea(Long teaId){
        if (existByIdTeaDTO(teaId)){
            teaRepository.deleteById(teaId);
            return true;
        }
        return false;
    }

    public boolean existByIdTeaDTO(Long id){
        return teaRepository.existsById(id);
    }

    public TeaDTO getTeaById(Long id){
        Tea tea = teaRepository.findById(id).orElse(null);

        if (Objects.isNull(tea)){
            return null;
        }

        TeaDTO teaDTO = teaConverter.convert(tea);
        teaDTO.setKindTeaDTO(kindTeaConverter.convert(kindTeaRepository.findById(tea.getKindId()).orElse(null)));
        teaDTO.setSortTeaDTO(sortTeaConverter.convert(sortTeaRepository.findById(tea.getSortTeaId()).orElse(null)));
        return teaDTO;
    }
}
