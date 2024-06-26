import java.util.*;

/**
 * 测试数组和 List 的转换
 */
public class TestArray2List {
    public static void main(String[] args) {
        //数组-》list
        Integer[] array = new Integer[]{1,2,3,4};
        List<Integer> list = Arrays.asList(array);
        System.out.println(list);//[1, 2, 3, 4]
        array[0]=5;
        System.out.println(list);//[5, 2, 3, 4]



        //list->array
        List<String> slist = new ArrayList<>();
        slist.add("111");
        slist.add("222");
        slist.add("333");
        String[] array1 = slist.toArray(new String[slist.size()]);
        for (String s :array1) {
            System.out.println(s);
        }

        slist.add("444");
        for (String s :array1) {
            System.out.println(s);
        }

        List<Integer> integers = Collections.synchronizedList(new ArrayList<Integer>);


    }
}
