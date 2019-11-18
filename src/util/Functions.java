package util;

import Function.*;

public class Functions {
    //[re-defined function
    public static <T> T reduce(F2<T> func, T...lst){
        if(lst.length==0)return null;
        T result=lst[0];
        for(int i=1;i<lst.length;i++){
            result=func.apply(result,lst[i]);
        }
        return result;
    }
}
