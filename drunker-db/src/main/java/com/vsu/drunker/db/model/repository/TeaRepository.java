package com.vsu.drunker.db.model.repository;

import com.vsu.drunker.db.model.entity.Tea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TeaRepository extends JpaRepository<Tea, Long>, JpaSpecificationExecutor<Tea> {
}
