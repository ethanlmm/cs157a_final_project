package backend.util;

import java.util.*;

public class Util {
    //make your  life easier












    @SafeVarargs
    public static <E> E[] arr(E... arr) {
        return arr;
    }

    @SafeVarargs
    public static <E> List<E> list(E... arr) {
        return Arrays.asList(arr);

}
    public static String str(String... strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder buffer = new StringBuilder();
        for (String str : strs) {
            buffer.append(str);
        }
        return buffer.toString();
    }

    public static void print(String... strs) {
        System.out.println(str(strs));
    }

    public static <E> LinkedList<E> stack(E... elements) {
        return new LinkedList<E>(Arrays.asList(elements)) {
        };
    }


    public static void main(String[] args) {
        List strs = list("a", "b");
        String[] arr = arr("a", "b");
        str(arr("a", "b"));

        LinkedList<String> strs1 = stack("hello", "world");

        print(strs1.pop());
        print(strs1.pop());

        print("Hello", " ", "world");

    }
}



