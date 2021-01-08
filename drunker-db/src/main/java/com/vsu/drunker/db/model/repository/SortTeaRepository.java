package com.vsu.drunker.db.model.repository;

import com.vsu.drunker.db.model.entity.SortTea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SortTeaRepository extends JpaRepository<SortTea, Long> {

    List<SortTea> findAllByKindIdIn(List<Long> kindIds);
}
