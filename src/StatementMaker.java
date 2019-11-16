import java.lang.StringBuffer;

public class StatementMaker {

    public String insert(String table_name, String[] fields_table, String[] values_table) {
        if (fields_table.length != values_table.length) {
            return "";
        }
        StringBuffer result = new StringBuffer();

        INSERT_INTO(result, table_name, fields_table);
        VALUE(result, values_table);

        return result.append(";").toString();

    }


    public String select(String[] select_colum, String from_statement, String where_statement) {
        StringBuffer result = new StringBuffer();
        SELECT(result, select_colum);
        FROM(result, from_statement);
        WHERE(result, where_statement);

        return result.append(";").toString();
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
            if (!isON || lst[i].matches("NULL|\\d|<|>|==|,")) result.append(lst[i]);
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

        String x = s.insert("medical", arr("FIRST_NAME", "LAST_NAME"), arr("Tom", "Woods"));
        String y = s.select(arr("A", "B", "C", "D"), "CUSTOMER", str("test", "==", "1"));
        System.out.println(x);
        System.out.println(y);
    }


}

