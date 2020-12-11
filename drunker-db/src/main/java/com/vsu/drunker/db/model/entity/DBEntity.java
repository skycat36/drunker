package com.vsu.drunker.db.model.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@ToString(exclude = {"count"})
public abstract class DBEntity<T> implements Serializable {
    /**
     * Field required to retrieve the number of records found on request
     */
    @Formula("COUNT(*) OVER()")
    private Long count;

    /**
     * The id field is required in all entities
     *
     * @return id entity
     */
    public abstract T getId();

}
