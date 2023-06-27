package com.jeterson.winthor.dataaccess.dataaccesscontrol.repository;

import com.jeterson.winthor.dataaccess.dataaccesscontrol.entity.DataAccessControlEntity;
import com.jeterson.winthor.dataaccess.dataaccesscontrol.entity.DataAccessControlEntityPK;
import com.jeterson.winthor.dataaccess.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataAccessControlJpaRepository extends JpaRepository<DataAccessControlEntity, DataAccessControlEntityPK> {

    @Query("SELECT d FROM DataAccessControlEntity d WHERE d.id.user = :user AND d.id.tableId = :tableId")
    List<DataAccessControlEntity> findByUserAndTable(UserEntity user, String tableId);
}
