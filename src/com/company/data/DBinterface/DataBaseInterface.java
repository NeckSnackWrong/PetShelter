package com.company.data.DBinterface;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataBaseInterface {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
