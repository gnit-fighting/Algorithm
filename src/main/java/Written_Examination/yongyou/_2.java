package Written_Examination.yongyou;

import java.util.*;

public class _2 {


    public ArrayList<Integer> findAllPerson(Integer n, int[][] meetings, int firstPerson) {
        // write code here
        HashSet<Integer> result = new HashSet<>();

        //人的编号 ： 【0，n-1】

        //时刻 0 ：
        result.add(0);
        result.add(firstPerson);

        //定义 map ， k：时间  v：涉及的人
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] meeting :meetings) {
            HashSet<Integer> thisset = map.get(meeting[2]);
            if (thisset==null) {
                HashSet<Integer> set = new HashSet<>();
                set.add(meeting[0]);
                set.add(meeting[1]);
                map.put(meeting[2],set);
            }else {
               thisset.add(meeting[0]);
               thisset.add(meeting[1]);
            }
        }

        //map根据 key 的值 自动有序
       // System.out.println(map);

        //一一取出时刻，看 set 是否有已经感染的人
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            HashSet<Integer> set = entry.getValue();

            Iterator<Integer> iterator = result.stream().iterator();
            while (iterator.hasNext()){
                Integer next = iterator.next();
                //有已经感染的人，这个 set 的全部人感染
                if(set.contains(next)){
                    result.addAll(set);
                    break;
                }
            }
        }


        Integer[] array = result.stream().toArray(Integer[]::new);
        Arrays.sort(array);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i :array) {
            list.add(i);
        }
        return list;
    }
}
