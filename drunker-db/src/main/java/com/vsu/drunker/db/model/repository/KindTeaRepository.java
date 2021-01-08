package com.vsu.drunker.db.model.repository;

import com.vsu.drunker.db.model.entity.KindTea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KindTeaRepository extends BaseJpaRepository<KindTea, Long> {
}
