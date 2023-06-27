package com.jeterson.winthor.dataaccess.dataaccesscontrol.adapter;

import com.jeterson.winthor.dataaccess.dataaccesscontrol.mapper.DataAccessControlDataAccessMapper;
import com.jeterson.winthor.dataaccess.dataaccesscontrol.repository.DataAccessControlJpaRepository;
import com.jeterson.winthor.dataaccess.user.mapper.UserDataAccessMapper;
import com.jeterson.winthor.domain.application.output.repository.DataAccessControlRepository;
import com.jeterson.winthor.domain.core.entities.DataAccessControl;
import com.jeterson.winthor.domain.core.entities.User;
import com.jeterson.winthor.domain.core.entities.DataAccessControlTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DataAccessControlRepositoryImpl implements DataAccessControlRepository{

    private final DataAccessControlJpaRepository dataAccessControlJpaRepository;
    private final DataAccessControlDataAccessMapper dataAccessControlDataAccessMapper;
    private final UserDataAccessMapper userDataAccessMapper;


    @Override
    public DataAccessControl getDataAccess(DataAccessControlTable table, User user) {
        var items = dataAccessControlJpaRepository.findByUserAndTable(userDataAccessMapper.userToUserEntity(user), table.getValue());
        var dataAccessControl = dataAccessControlDataAccessMapper.entityToDataAccessControl(items, table, user);
        return dataAccessControl;
    }
}
