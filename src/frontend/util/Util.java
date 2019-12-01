package frontend.util;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Util {

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
