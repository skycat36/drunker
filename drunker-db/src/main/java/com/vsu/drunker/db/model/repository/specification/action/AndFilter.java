package com.vsu.drunker.db.model.repository.specification.action;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@Getter
public class AndFilter<T> {

    private Specification<T> specification;

    public void add(Specification<T> spec){
        if (specification == null) {
            specification = spec;
        } else {
            if (spec != null) {
                specification.and(spec);
            }
        }
    }

    public void or(Specification<T> spec){
        if (specification == null) {
            specification = spec;
        } else {
            if (spec != null) {
                specification.or(spec);
            }
        }
    }

    public boolean isEmpty(){
        return Objects.isNull(specification);
    }

}
