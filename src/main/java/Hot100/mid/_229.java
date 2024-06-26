package Hot100.mid;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 多数元素 II
 */
public class _229 {
    //1.哈希计数法
    public List<Integer> majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                result.add(entry.getKey());
            }

        }
        return result;


    }


    //2.摩尔投票法
    public List<Integer> majorityElement(int[] nums) {
        //本题最多右两个参选人
        int cand1 = 0;
        int cnt1 = 0;
        int cand2 = 0;
        int cnt2 = 0;
        for (int i :nums) {
            if(cnt1!=0 && cand1==i){
                cnt1++;
            }else if(cnt2!=0 && cand2==i){
                cnt2++;

            }else if(cnt1==0 && ++cnt1>=0){
                cand1=i;
            } else if (cnt2==0 && ++cnt2>=0) {
                cand2=i;
            }else {
                cnt2--;
                cnt1--;
            }
        }

        int newcnt1=0;
        int newcnt2=0;
        for (int i :nums) {
            if(cand1==i){
                newcnt1++;
            }else  if(cand2==i){
                newcnt2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        if(newcnt1> nums.length/3){
            result.add(cand1);
        }
        if(newcnt2 > nums.length){
            result.add(cand2);
        }

        return  result;

    }



}
