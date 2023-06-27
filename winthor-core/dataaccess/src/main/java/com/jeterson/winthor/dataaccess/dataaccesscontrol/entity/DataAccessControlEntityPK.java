package com.jeterson.winthor.dataaccess.dataaccesscontrol.entity;

import com.jeterson.winthor.dataaccess.user.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class DataAccessControlEntityPK implements Serializable {
    private static final long serialVersionUID = -5042417231357452582L;
    @ManyToOne()
    @JoinColumn(name = "CODFUNC")
    private UserEntity user;
    @Column(name = "CODTABELA")
    private String tableId;
    @Column(name = "CODIGOA")
    private String alphaValue;
    @Column(name = "CODIGON")
    private Integer numberValue;
}
