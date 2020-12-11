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
@Table(name = "SORT_OF_TEA", schema = DBScheme.DRUNKER_SCHEMA)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortTea extends DBEntity<Long> {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "SEQ_SORT_OF_TEA", schema = DBScheme.DRUNKER_SCHEMA,
            sequenceName = "SORT_OF_TEA_ID_SEQ")
    @GeneratedValue(generator = "SEQ_SORT_OF_TEA", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "KIND_ID", nullable = false)
    private Long kindId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "KIND_ID", updatable = false, insertable = false, nullable = false)
    private KindTea kindTea;

    @Override
    public Long getId() {
        return id;
    }

}
