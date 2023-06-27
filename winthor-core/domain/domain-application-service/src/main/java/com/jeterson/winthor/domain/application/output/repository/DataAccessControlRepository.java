package com.jeterson.winthor.domain.application.output.repository;

import com.jeterson.winthor.domain.core.entities.DataAccessControl;
import com.jeterson.winthor.domain.core.entities.User;
import com.jeterson.winthor.domain.core.entities.DataAccessControlTable;

public interface DataAccessControlRepository {

    DataAccessControl getDataAccess(DataAccessControlTable table, User user);
}
