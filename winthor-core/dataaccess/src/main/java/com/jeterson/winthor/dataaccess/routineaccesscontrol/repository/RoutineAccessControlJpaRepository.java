package com.jeterson.winthor.dataaccess.routineaccesscontrol.repository;


import com.jeterson.winthor.dataaccess.routineaccesscontrol.entity.RoutineAccessControlEntity;
import com.jeterson.winthor.dataaccess.routineaccesscontrol.entity.RoutineAccessControlEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineAccessControlJpaRepository extends JpaRepository<RoutineAccessControlEntity, RoutineAccessControlEntityPK> {
}
