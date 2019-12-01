package backend;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Connector {
    static String default_addr="jdbc:mysql://localhost:3306/mydb";;
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

    //CREDIT: Kevin
    public static DefaultTableModel display_result(ResultSet set) throws SQLException {
        //Convert the results to a DefaultTableModel
        ResultSetMetaData resultsMetaData = set.getMetaData();
        int cols = resultsMetaData.getColumnCount();
        String[] colNames = new String[cols];
        for (int i = 0; i < cols; i++)
        {
            colNames[i] = resultsMetaData.getColumnName(i);
        }

        DefaultTableModel model = new DefaultTableModel(colNames, 0);
        while (set.next())
        {

            Object[] row = new Object[cols];
            for (int i = 0; i < cols; i++)
            {
                row[i] = set.getObject(i);
            }
            model.addRow(row);
        }

        return model;
    }
    }






