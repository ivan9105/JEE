package com.jee.bean.util;

import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Иван on 26.02.2017.
 */
@Stateless(name = "SqlRunner")
public class SqlRunner {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "root";

    public List<Map<String, Object>> select(String query) {
        List<Map<String, Object>> res = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String name = metadata.getColumnName(i);
                    int type = metadata.getColumnType(i);
                    Object value = null;
                    if (type == Types.VARCHAR || type == Types.CHAR) {
                        value = rs.getString(name);
                    } else if (type == Types.BOOLEAN) {
                        value = rs.getBoolean(name);
                    } else if (type == Types.INTEGER || type == Types.BIGINT || type == Types.NUMERIC) {
                        value = rs.getInt(name);
                    } else if (type == Types.DOUBLE) {
                        value = rs.getDouble(name);
                    } else if (type == Types.TIME || type == Types.TIMESTAMP || type == Types.DATE) {
                        value = rs.getDate(name);
                    } else if (type == Types.DECIMAL) {
                        value = rs.getBigDecimal(name);
                    }
                    map.put(name, value);
                }
                res.add(map);
            }
        } catch (ClassNotFoundException | SQLException ignore) {
            System.out.println(ignore.getMessage());
        } finally {
            closeConnection(conn, stmt);
        }

        return res;
    }

    private void closeConnection(Connection conn, Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ignore) {
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException ignore) {
        }
    }
}
