package backend.util;

import java.sql.*;

public class Connector {
    static String default_addr="jdbc:mysql://localhost:3306/TEST";
    static String default_user="root";
    static String default_password="2147483647";

    private static Connection con=null;

    public static void connect(String addr,String admin,String password) throws SQLException {
        if(con==null) {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection(addr, admin, password);
        }
    }
    public static ResultSet query(String statement) throws SQLException {
        if(con==null)connect(default_addr,default_user,default_password);
        Statement stmt=con.createStatement();
        return stmt.executeQuery (statement);
    }

    public static void update(String statement) throws SQLException {
            if(con==null)connect(default_addr,default_user,default_password);
            Statement stmt=con.createStatement();
            stmt.executeUpdate(statement);
    }



}




