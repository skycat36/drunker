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
@Table(name = "USR", schema = DBScheme.DRUNKER_SCHEMA)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends DBEntity<Long> {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "SEQ_SORT_OF_TEA", schema = DBScheme.DRUNKER_SCHEMA,
            sequenceName = "SORT_OF_TEA_ID_SEQ")
    @GeneratedValue(generator = "SEQ_SORT_OF_TEA", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "FIO", nullable = false)
    private String fio;

    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ROLE_ID", nullable = false)
    private Long roleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLE_ID", updatable = false, insertable = false, nullable = false)
    private Role role;

    @Override
    public Long getId() {
        return id;
    }

}
