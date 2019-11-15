import java.lang.StringBuffer;

public class StatementMaker {
    public static String[] test1 = new String[]{"FIRST_NAME","LAST_NAME", "AGE", "ADDRESS"};
    public static String[] test2 = new String[]{"Tom", "Whatever", "2", "123 Street"};


    public StringBuffer asTuple(String[] lst, Boolean bracket) {
        StringBuffer result = new StringBuffer();

        if (bracket) result.append("(");
        for (int i = 0; i < lst.length - 1; i++) {
            result.append(str(lst[i])+",");
    }
        result.append(str(lst[lst.length - 1]));
        if (bracket) result.append(")");
        return result;
    }


    public String insertStatement(String table_name, String[] fields_table, String[] values_tables) {
        if (fields_table.length != values_tables.length) { return ""; }
        return new StringBuffer("INSERT INTO " + table_name + asTuple(fields_table, true) + " VALUES" + asTuple(values_tables, true) + ";").toString();

    }

    public String selectStatement(String[] select_colum, String from_statement, String where_statement) {
        return new StringBuffer(SELECT(select_colum) + FROM(from_statement) + WHERE(where_statement) + ";").toString();
    }
    private String SELECT(String[] colum){
        if(colum.length>0)return "SELECT "+asTuple(colum,false);
        return "SELECT *";
    }
    private String FROM(String Statement){
        return " FROM "+ Statement;
    }
    private String WHERE(String statement){
        if(!statement.equals(""))return " WHERE "+statement;
        return "";
    }
    //a string wrapper, it will skip non-string String;
    public static String str(String x){
        if(x.matches("-?\\d+(\\.\\d+)?")) return x;
        if(x.matches("NULL")) return x;
        return "\""+x+"\"";

    }



    public static void main(String[] args) {
        StatementMaker q = new StatementMaker();
        String x = q.insertStatement("medical", test1, test2);
        //x = q.selectStatement(new String[]{"A", "B"}, "CUSTOMER", str("test") +"==1");
        System.out.println(x);
    }


}

