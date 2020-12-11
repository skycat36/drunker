package com.vsu.drunker.db.model.repository;

import com.vsu.drunker.db.model.entity.KindTea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KindTeaRepository extends JpaRepository<KindTea, Long> {
}
