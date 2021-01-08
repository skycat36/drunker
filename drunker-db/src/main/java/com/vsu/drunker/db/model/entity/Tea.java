package com.vsu.drunker.db.model.entity;

import com.vsu.drunker.db.config.DBScheme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.lang.reflect.Field;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SORT_TEA_ID", updatable = false, insertable = false, nullable = false)
    private SortTea sortTea;

    @Column(name = "KIND_ID", nullable = false)
    private Long kindId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KIND_ID", updatable = false, insertable = false, nullable = false)
    private KindTea kindTea;

    @Column(name = "COUNT_ON_WAREHOUSE", nullable = false)
    private Integer countOnWarehouse;

    public static final Field NAME;
    public static final Field SORT_TEA_ID;
    public static final Field KIND_ID;

    static {
        try{
            NAME = Tea.class.getDeclaredField("name");
            SORT_TEA_ID = Tea.class.getDeclaredField("sortTeaId");
            KIND_ID = Tea.class.getDeclaredField("kindId");
        }catch (Exception ex){
            throw new RuntimeException("Error init fields");
        }
    }

    @Override
    public Long getId() {
        return id;
    }
}
