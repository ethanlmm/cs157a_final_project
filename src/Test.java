import static backend.util.Util.*;
import static backend.StatementMaker.*;
import static backend.Connector.*;
import backend.function.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        F<String> insert_to_TEST=X ->{
            String statement=INSERT_STATEMENT("TEST",arr("First_name"),X);
            update(statement);
            return statement;
        };

        String s0=insert_to_TEST.apply("a");
        print(s0);

       // arr()== SELECT *, str()= no where statement
       String s1=SELECT_STATEMENT("TEST",arr(),str());
       print(s1);
       ResultSet results=query(s1);
        while (results.next())
            print(results.getString (1));
    }
//
//    String where=str("\"THC_num\"","=",""+viewer.getTableContentsAt(changedRows[i],0));
//    String content=""+viewer.getTableContentsAt(changedRows[i],changedCols[i]);
//    String column=""+viewer.getTableContentsAt(0,changedCols[i]);
//    String statement =UPDATE_STATEMENT("PATIENT", arr(column),arr(content),where);
//    print(statement);
//						try {
//        update(statement);
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//    }

}


