import java.util.ArrayList;

public interface F<T> {


    default T execute(T x, T y) {
        return null;
    }

    default T execute(T x) {
        return null;
    }

    default T reduce(T...list){
        T result=list[0];
        if(list.length==1) return result;
        for(int i=1;i<list.length;i++){
            result= execute(result,list[i]);
        }
        return result;
    }
    default ArrayList<T> map(T... list){
        ArrayList<T> result=new ArrayList<>();
        if (list.length==0) return result;
        for(T t : list){
            T x= execute(t);
            if(x != null){result.add(x);}
        }
        return result;
    }

    }






