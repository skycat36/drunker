package com.vsu.drunker.db.model.entity;

import com.vsu.drunker.db.config.DBScheme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "TEA", schema = DBScheme.DRUNKER_SCHEMA)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tea extends DBEntity<Long> {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "SEQ_TEA", schema = DBScheme.DRUNKER_SCHEMA,
            sequenceName = "TEA_ID_SEQ")
    @GeneratedValue(generator = "SEQ_TEA", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SORT_TEA_ID", nullable = false)
    private Long sortTeaId;

    @Column(name = "COUNT_ON_WAREHOUSE", nullable = false)
    private Integer countOnWarehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SORT_TEA_ID", updatable = false, insertable = false, nullable = false)
    private SortTea sortTea;

    @Override
    public Long getId() {
        return id;
    }
}
