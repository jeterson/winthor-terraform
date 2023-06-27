package com.jeterson.winthor.domain.application.input.service;

import com.jeterson.winthor.domain.application.dto.datacontrolaccess.DataAccessControlRequest;
import com.jeterson.winthor.domain.core.entities.DataAccessControl;
import com.jeterson.winthor.domain.core.entities.User;
import com.jeterson.winthor.domain.core.entities.DataAccessControlTable;

public interface DataAccessControlApplicationService {

    boolean hasAccess(DataAccessControlTable table, User user, String alphaValue);

    boolean hasAccess(DataAccessControlTable table, User user, Integer numberValue);
    boolean hasAccess(DataAccessControlTable table, Integer numberValue);
    boolean hasAccess(DataAccessControlTable table, String alphaValue);
    DataAccessControl getDataAccess(DataAccessControlTable table, User user);
    DataAccessControl getDataAccess(DataAccessControlTable table);

    DataAccessControl getDataAccess(DataAccessControlRequest dataAccessControlRequest);
}
