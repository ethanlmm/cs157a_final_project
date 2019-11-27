package backend.util;

import java.lang.StringBuffer;

import static backend.util.Util.*;

public class StatementMaker {



    public static String UPDATE_STATEMENT(String table_name,String[] columns,String[] new_data,String where_statement){
        StringBuffer result = new StringBuffer();
        UPDATE(result,table_name);
        SET(result,columns,new_data);
        WHERE(result,where_statement);
        return result.append(";").toString();
    }

    private static void UPDATE(StringBuffer result,String table_name){
        result.append(str("UPDATE ",table_name));
    }
    private static void SET(StringBuffer result,String[] columns,String[] new_data){
        result.append("SET ");
        for(int i=0;i<columns.length;i++){
            result.append(str(columns[i],"=",STR(new_data[i])));
            if(i<columns.length-1)result.append(",");
        }
    }



    public static String INSERT_STATEMENT(String table_name, String[] fields_table, String[] values_table) {
        if (fields_table.length != values_table.length) {
            print("INSERT_STATEMENT: # values doesn't match with # of attribute ");
            return "";
        }
        StringBuffer result = new StringBuffer();

        INSERT_INTO(result, table_name, fields_table);
        VALUE(result, values_table);

        return result.append(";").toString();

    }


    public static String SELECT_STATEMENT(String table_name, String[] columns, String where_statement) {
        StringBuffer result = new StringBuffer();
        SELECT(result, columns);
        FROM(result, table_name);
        WHERE(result, where_statement);

        return result.append(";").toString();
    }

    private static void SELECT(StringBuffer target, String[] colum) {
        if (colum.length > 0) target.append("SELECT " + strWrapper(colum, ",", false));
        else target.append("SELECT *");
    }

    private static void FROM(StringBuffer target, String Statement) {
        target.append(" FROM " + Statement);
    }

    private static void WHERE(StringBuffer target, String statement) {
        if (!statement.equals("")) target.append(" WHERE " + statement);
    }

    private static void INSERT_INTO(StringBuffer target, String table_name, String[] fields_table) {
        target.append("INSERT INTO ");
        target.append(table_name);
        target.append(asTuple(fields_table, false));
    }

    private static void VALUE(StringBuffer target, String[] values_table) {
        target.append(" VALUE ");
        target.append(asTuple(values_table, true));
    }

    //make life easier
    public static String[] list(String... lst) {
        return lst;
    }

    public static String STR(String... x) {
        return strWrapper(x, "", true).toString();
    }

    //a string wrapper, it will skip non-string String;
    //isOn: auto wrapp string with "" if true
    public static StringBuffer strWrapper(String[] lst, String spliter, Boolean isON) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < lst.length; i++) {
            if (!isON || lst[i].matches("NULL|[0-9]*|\\d|<|>|==|=|[0-9]|,")) result.append(lst[i]);
            else result.append("\"" + lst[i] + "\"");
            if (!spliter.equals("") && i < lst.length - 1) result.append(spliter);
        }
        return result;
    }

    public static StringBuffer asTuple(String[] lst, boolean isON) {
        StringBuffer result = new StringBuffer("(");
        result.append(strWrapper(lst, ",", isON));
        result.append(")");
        return result;
    }

    public static void main(String[] args) {
        StatementMaker s = new StatementMaker();

        String x = INSERT_STATEMENT("medical", list("FIRST_NAME", "LAST_NAME"), list("Tom", "Woods"));
        String y = SELECT_STATEMENT("CUSTOMER",list("A", "B", "C", "D"), STR("test", "==", "1000"));
        String z = UPDATE_STATEMENT("CUSTOMER",arr("A", "B", "C", "D"),arr("1","str2","3","4"), STR("test", "==", "1000"));
        print(x);
        print(y);
        print(z);
    }


}

