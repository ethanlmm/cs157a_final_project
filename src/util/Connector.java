package util;

import java.sql.*;

public class Connector {
    String addr="localhost:3306/project";
    String admin="";
    String password="";
    public Statement stmt;

    public Connector() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection conn = DriverManager.getConnection(addr, admin, password);
        stmt = conn.createStatement();
    }
    public ResultSet query(String x) throws SQLException {
        return stmt.executeQuery (x);
    }
        }




