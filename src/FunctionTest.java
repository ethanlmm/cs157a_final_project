import java.util.ArrayList;

public class FunctionTest{

    public static void main(String[] args) {
        F<Integer> func=new F<Integer>(){public Integer execute(Integer x, Integer y){return x+y;}};
        F<String> func1=new F<String>(){public String execute(String x, String y){return x+y;}};
        F<String> func2=new F<String>(){public String execute(String x){return x+"!";}};
        F<String> filter=new F<String>(){public String execute(String x){
            if(x.equals("A")) return null;
            return x+"!";}
        };
        Integer x=func.reduce(0,1,2,3);
        String y=func1.reduce("A","B","C");
        ArrayList<String> z=func2.map("A","B","C");
        ArrayList<String> p=filter.map("A","B","C");
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(p);
    }

}

