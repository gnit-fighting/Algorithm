package Hot100.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        for (int i = 2; i <=numRows ; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> last = result.get(result.size() - 1);
            for (int j = 0; j < i; j++) {
                if(j==0 || j==i-1){
                    list.add(1);
                    continue;
                }
                list.add(last.get(j-1) + last.get(j));
            }
            result.add(list);
        }
        return  result;
    }
}
