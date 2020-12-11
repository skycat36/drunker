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
@Table(name = "BASKET_OF_GOODS", schema = DBScheme.DRUNKER_SCHEMA)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCart extends DBEntity<Long> {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "SEQ_BASKET_OF_GOODS", schema = DBScheme.DRUNKER_SCHEMA,
            sequenceName = "BASKET_OF_GOODS_ID_SEQ")
    @GeneratedValue(generator = "SEQ_BASKET_OF_GOODS", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "TEA_ID", nullable = false)
    private Long teaId;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "COUNT_IN_CARD", nullable = false)
    private Integer countInCard;

    @Override
    public Long getId() {
        return id;
    }

}
