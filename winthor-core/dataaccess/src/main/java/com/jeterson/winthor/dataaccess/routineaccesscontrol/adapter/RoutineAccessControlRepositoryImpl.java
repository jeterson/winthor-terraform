package com.jeterson.winthor.dataaccess.routineaccesscontrol.adapter;

import com.jeterson.winthor.dataaccess.routineaccesscontrol.entity.RoutineAccessControlEntityPK;
import com.jeterson.winthor.dataaccess.routineaccesscontrol.mapper.RoutineAccessControlDataAccessMapper;
import com.jeterson.winthor.dataaccess.routineaccesscontrol.repository.RoutineAccessControlJpaRepository;
import com.jeterson.winthor.dataaccess.user.mapper.UserDataAccessMapper;
import com.jeterson.winthor.domain.application.output.repository.RoutineAccessControlRepository;
import com.jeterson.winthor.domain.core.entities.RoutineAccessControl;
import com.jeterson.winthor.domain.core.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RoutineAccessControlRepositoryImpl implements RoutineAccessControlRepository {

    private final RoutineAccessControlJpaRepository routineAccessControlJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;
    private final RoutineAccessControlDataAccessMapper routineAccessControlDataAccessMapper;

    @Override
    public Optional<RoutineAccessControl> findById(User user, Integer controlCode, Integer routineCode) {
        var id = new RoutineAccessControlEntityPK();
        id.setRoutineCode(routineCode);
        id.setControlCode(controlCode);
        id.setUser(userDataAccessMapper.userToUserEntity(user));

        return routineAccessControlJpaRepository
                .findById(id)
                .map(routineAccessControlDataAccessMapper::entityToRoutineAccessControl);

    }
}
