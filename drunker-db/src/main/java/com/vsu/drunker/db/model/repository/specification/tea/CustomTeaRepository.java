package com.vsu.drunker.db.model.repository.specification.tea;

import com.vsu.drunker.db.model.entity.Tea;
import com.vsu.drunker.db.model.repository.TeaRepository;
import com.vsu.drunker.db.model.repository.specification.BaseSpecification;
import org.springframework.stereotype.Component;

@Component
public class CustomTeaRepository extends BaseSpecification<Tea, TeaRepository> {

    public CustomTeaRepository(TeaRepository teaRepository) {
        super(teaRepository);
    }
}
