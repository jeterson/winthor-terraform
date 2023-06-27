package com.jeterson.winthor.dataaccess.routineaccesscontrol.mapper;

import com.jeterson.winthor.dataaccess.routineaccesscontrol.entity.RoutineAccessControlEntity;
import com.jeterson.winthor.dataaccess.user.mapper.UserDataAccessMapper;
import com.jeterson.winthor.domain.core.entities.RoutineAccessControl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoutineAccessControlDataAccessMapper {

    private final UserDataAccessMapper userDataAccessMapper;

    public RoutineAccessControlEntity routineAccessControlToEntity(RoutineAccessControl routineAccessControl) {
        var entity = new RoutineAccessControlEntity();
        entity.setAccess(routineAccessControl.isAccess() ? "S" : "N");
        entity.setControlCode(routineAccessControl.getControlCode());
        entity.setUser(userDataAccessMapper.userToUserEntity(routineAccessControl.getUser()));
        entity.setRoutineCode(entity.getRoutineCode());
        return entity;
    }
    public RoutineAccessControl entityToRoutineAccessControl(RoutineAccessControlEntity entity) {
        return RoutineAccessControl
                .builder()
                .access(entity.getAccess().equals("S") ? true : false)
                .controlCode(entity.getControlCode())
                .routineCode(entity.getRoutineCode())
                .user(userDataAccessMapper.userEntityToUser(entity.getUser()))
                .build();
    }
}
