package com.vsu.drunker.db.model.entity;

import com.vsu.drunker.db.config.DBScheme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "NOTIFICATION", schema = DBScheme.DRUNKER_SCHEMA)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification extends DBEntity<Long> {

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

    @Override
    public Long getId() {
        return id;
    }
}
