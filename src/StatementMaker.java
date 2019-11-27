import java.lang.StringBuffer;
import static backend.util.Util.*;
public class StatementMaker {

    public String INSERT_STATEMENT(String table_name, String[] fields_table, String[] values_table) {
        if (fields_table.length != values_table.length) {
            return "";
        }
        StringBuffer result = new StringBuffer();

        INSERT_INTO(result, table_name, fields_table);
        VALUE(result, values_table);

        return result.append(";").toString();

    }
    public String UPDATE_STATEMENT(String table_name,String[] columns,String[] new_values,String where_statement){
        StringBuffer result = new StringBuffer();
        UPDATE(result,table_name);
        SET(result,columns,new_values);
        WHERE(result,where_statement);
    return result.append(";").toString();
    }

    public String SELECT_STATEMENT(String[] columns, String from_statement, String where_statement) {
        StringBuffer result = new StringBuffer();
        SELECT(result, columns);
        FROM(result, from_statement);
        WHERE(result, where_statement);

        return result.append(";").toString();
    }

    private void UPDATE(StringBuffer target,String name){
        target.append("UPDATE ").append(name).append(" ");

    }
    private void SET(StringBuffer target,String[] column, String[] new_value){
        if(column.length!=new_value.length){
            print("UPDATE.SET: column.length!=new_value.length");
            return;
        }

        target.append("SET ");
        for (int i=0;i<new_value.length;i++){
            target.append(column[i]).append(" = ").append(strWrapper(arr(new_value[i]), "", true));
            if(i<new_value.length-1){
                target.append(",");
            }
        }
    }

    private void SELECT(StringBuffer target, String[] colum) {
        if (colum.length > 0) target.append("SELECT ").append(strWrapper(colum, ",", false));
        else target.append("SELECT *");
    }

    private void FROM(StringBuffer target, String Statement) {
        target.append(" FROM ").append(Statement);
    }

    private void WHERE(StringBuffer target, String statement) {
        if (!statement.equals("")) target.append(" WHERE ").append(statement);
    }

    private void INSERT_INTO(StringBuffer target, String table_name, String[] fields_table) {
        target.append("INSERT INTO ");
        target.append(table_name);
        target.append(asTuple(fields_table, false));
    }

    private void VALUE(StringBuffer target, String[] values_table) {
        target.append(" VALUE ");
        target.append(asTuple(values_table, true));
    }

    //make life easier
    public static String[] arr(String... lst) {
        return lst;
    }

    public static String str(String... x) {
        return strWrapper(x, "", true).toString();
    }

    //a string wrapper, it will skip non-string String;
    //isOn: auto wrapp string with "" if true
    public static StringBuffer strWrapper(String[] lst, String spliter, Boolean isON) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < lst.length; i++) {
            if (!isON || lst[i].matches("NULL|\\d|[0-9]|<|>|==|,|=")) result.append(lst[i]);
            else result.append("\"").append(lst[i]).append("\"");
            if (!spliter.equals("") && i < lst.length - 1) result.append(spliter);
        }
        return result;
    }

    public StringBuffer asTuple(String[] lst, boolean isON) {
        StringBuffer result = new StringBuffer("(");
        result.append(strWrapper(lst, ",", isON));
        result.append(")");
        return result;
    }

    public static void main(String[] args) {
        StatementMaker s = new StatementMaker();

        String x = s.INSERT_STATEMENT("medical", arr("FIRST_NAME", "LAST_NAME"), arr("Tom", "Woods"));
        String y = s.UPDATE_STATEMENT("CUSTOMER",arr("A", "B", "C", "D"), arr("str1","1","str2","4"), str("test", "==", "1"));
        System.out.println(x);
        System.out.println(y);
    }


}

