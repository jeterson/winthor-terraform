package com.jeterson.winthor.dataaccess.dataaccesscontrol.mapper;

import com.jeterson.winthor.dataaccess.dataaccesscontrol.entity.DataAccessControlEntity;
import com.jeterson.winthor.dataaccess.user.mapper.UserDataAccessMapper;
import com.jeterson.winthor.domain.core.entities.DataAccessControl;
import com.jeterson.winthor.domain.core.entities.User;
import com.jeterson.winthor.domain.core.entities.DataAccessControlTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataAccessControlDataAccessMapper {

    private final UserDataAccessMapper userDataAccessMapper;

    public DataAccessControl entityToDataAccessControl(List<DataAccessControlEntity> dataAccessControlEntities, DataAccessControlTable table, User user) {
        if(dataAccessControlEntities.isEmpty())
            return DataAccessControl.builder()
                    .table(table)
                    .alphaCode(new ArrayList<>())
                    .numberCode(new ArrayList<>())
                    .user(user)
                    .build();

        var alphaValues = dataAccessControlEntities.stream().map(x -> x.getAlphaValue()).collect(Collectors.toList());
        var numberValues = dataAccessControlEntities.stream().map(x -> x.getNumberValue()).collect(Collectors.toList());
        user.removePassword();
        return DataAccessControl.builder()
                .user(user)
                .alphaCode(alphaValues)
                .numberCode(numberValues)
                .table(table)
                .build();
    }
}
