package com.vsu.drunker.db.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseJpaRepository<T,F> extends JpaRepository<T, F> {

    List<T> findAllByIdIn(List<F> Ids);
}
