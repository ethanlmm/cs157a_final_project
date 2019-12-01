package frontend.util;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Util {

    //CREDIT: Kevin
    public static String[] getAttrtibute(ResultSet set) throws SQLException {
        ResultSetMetaData resultsMetaData = set.getMetaData();
        int limit = resultsMetaData.getColumnCount();
        String[] arr = new String[limit];
        for (int i = 1; i <=limit; i++) {
            arr[i-1] = resultsMetaData.getColumnName(i);
        }
        return arr;
    }

    //CREDIT: Kevin
    public static DefaultTableModel getData(DefaultTableModel model,ResultSet set) throws SQLException {
        while (set.next()){
            int limit=set.getMetaData().getColumnCount();
            Object[] row = new Object[limit];

            for (int i = 1; i <= limit; i++) {
                row[i - 1] = set.getObject(i);
            }
            model.addRow(row);
        }
        return model;
    }

}
