package com.vsu.drunker.web.bean.servise.tea;

import com.vsu.drunker.db.model.entity.Tea;
import com.vsu.drunker.db.model.repository.TeaRepository;
import com.vsu.drunker.db.model.repository.specification.action.AndFilter;
import com.vsu.drunker.db.model.repository.specification.tea.CustomTeaRepository;
import com.vsu.drunker.web.bean.converter.TeaConverter;
import com.vsu.drunker.web.data.TeaDTO;
import com.vsu.drunker.web.data.tea.TeaFilterDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class TeaService {

    private final TeaRepository teaRepository;
    private final CustomTeaRepository customTeaRepository;
    private final TeaConverter teaConverter;

    public List<TeaDTO> getTeaByFilter(TeaFilterDTO teaFilterDTO){
        if (teaFilterDTO != null) {
            AndFilter<Tea> andFilter = new AndFilter<>();
            if (Objects.nonNull(teaFilterDTO.getListSorts())){
                andFilter.add(customTeaRepository.inTo(Tea.SORT_TEA_ID, teaFilterDTO.getListSorts()));
            }

            if (Objects.nonNull(teaFilterDTO.getListKinds())){
                andFilter.add(customTeaRepository.inTo(Tea.KIND_ID, teaFilterDTO.getListKinds()));
            }

            if (!andFilter.isEmpty()){
                return teaRepository.findAll(andFilter.getSpecification()).stream().map(teaConverter::convert).collect(Collectors.toList());
            }
        }
        return teaRepository.findAll().stream().map(teaConverter::convert).collect(Collectors.toList());
    }

    @Transactional
    public TeaDTO createTea(TeaDTO teaDTO){
        return teaConverter.convert(teaRepository.save(teaConverter.convert(teaDTO)));
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
        return teaConverter.convert(teaRepository.findById(id).orElse(null));
    }
}
