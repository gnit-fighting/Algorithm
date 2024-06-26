import Hot100.easy.ListNode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 本题 和乐扣 1751 一样【去看 1751笔记】
 */
public class Test {
    public static void main(String[] args) {
       Integer[] array = new Integer[]{1,2,3};
        List<Integer> list =Arrays.asList(1, 2, 3);
//        list.remove(2);
//        list.add(4);
        System.out.println(list);

        Integer[] array2 = new Integer[]{1,2,3};
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(array2));
        System.out.println(integers);

        List<Integer> collect = Arrays.stream(array2).collect(Collectors.toList());
        collect.add(4);
        System.out.println(collect);

        ListNode listNode = new ListNode(0);
        Class<? extends ListNode> aClass = listNode.getClass();
        try {
            ListNode listNode1 = aClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        try {
            Constructor<? extends ListNode> constructor = aClass.getConstructor();
            ListNode listNode1 = constructor.newInstance();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }







    }
}
