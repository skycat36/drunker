package com.vsu.drunker.db.model.repository;

import com.vsu.drunker.db.model.entity.SortTea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SortTeaRepository extends JpaRepository<SortTea, Long> {
}
