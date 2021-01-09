package com.vsu.drunker.db.model.entity;

import com.vsu.drunker.db.config.DBScheme;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "ROLE", schema = DBScheme.DRUNKER_SCHEMA)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Role extends DBEntity<Long> {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "SEQ_ROLE", schema = DBScheme.DRUNKER_SCHEMA,
            sequenceName = "ROLE_ID_SEQ")
    @GeneratedValue(generator = "SEQ_ROLE", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    @lombok.NonNull
    private String name;

    @Override
    public Long getId() {
        return id;
    }
}
