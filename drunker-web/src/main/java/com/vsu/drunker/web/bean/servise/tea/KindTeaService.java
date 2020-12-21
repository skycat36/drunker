package com.vsu.drunker.web.bean.servise.tea;

import com.vsu.drunker.db.model.repository.KindTeaRepository;
import com.vsu.drunker.web.bean.converter.KindTeaConverter;
import com.vsu.drunker.web.data.KindTeaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class KindTeaService {

    private final KindTeaRepository kindTeaRepository;
    private final KindTeaConverter kindTeaConverter;

    public KindTeaService(KindTeaRepository kindTeaRepository, KindTeaConverter kindTeaConverter) {
        this.kindTeaRepository = kindTeaRepository;
        this.kindTeaConverter = kindTeaConverter;
    }

    @Transactional
    public KindTeaDTO createKindTea(KindTeaDTO kindTeaDTO){
        return kindTeaConverter.convert(kindTeaRepository.save(kindTeaConverter.convert(kindTeaDTO)));
    }

    @Transactional
    public KindTeaDTO updateKindTea(Long kindTeaId, KindTeaDTO kindTeaDTO){
        return kindTeaConverter.convert(kindTeaRepository.save(kindTeaConverter.convert(kindTeaId, kindTeaDTO)));
    }

    @Transactional
    public boolean deleteKindTea(Long teaId){
        if (existByIdKindTeaDTO(teaId)){
            kindTeaRepository.deleteById(teaId);
            return true;
        }
        return false;
    }

    public boolean existByIdKindTeaDTO(Long id){
        return kindTeaRepository.existsById(id);
    }

    public List<KindTeaDTO> getAllKindTeaDTO(){
        return kindTeaRepository.findAll().stream().map(kindTeaConverter::convert).collect(Collectors.toList());
    }
}
