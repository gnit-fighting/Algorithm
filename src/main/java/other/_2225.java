package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> win = new HashMap<>();
        Map<Integer,Integer> lose = new HashMap<>();
        for (int i = 0; i < matches.length; i++) {
            win.put(matches[i][0],win.getOrDefault(matches[i][0],0)+1);
            lose.put(matches[i][1],lose.getOrDefault(matches[i][1],0)+1);
        }
        List<Integer> ans0 = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry :win.entrySet()) {
            Integer key = entry.getKey();
            if(lose.get(key)==null){
                ans0.add(key);
            }
        }
        for (Map.Entry<Integer,Integer> entry  :lose.entrySet()) {
            if(entry.getValue()==1){
                ans1.add(entry.getKey());
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        ans1.sort((v1,v2)-> {return v1-v2;});
        ans0.sort((v1,v2)-> {return v1-v2;});
        result.add(ans0);
        result.add(ans1);


        return result ;
    }
}
