package other;

import java.security.cert.CertificateNotYetValidException;
import java.util.ArrayList;
import java.util.Arrays;

public class _1751 {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int[][] dp = new int[events.length][k + 1];
        for (int j = 0; j < k + 1; j++) {
            dp[0][j] = events[0][2];
        }
        for (int i = 0; i < events.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < events.length; i++) {
            for (int j = 1; j < k + 1; j++) {
//                int last = 0;
//                boolean findLast = false;
//                for (int t = i-1; t >= 0  ; t--) {
//                    if(events[i][0]  > events[t][1]){
//                        last = t;
//                        findLast = true;
//                        break;
//                    }
//                }
//                if(findLast){
//                    dp[i][j]=Math.max(dp[i-1][j],dp[last][j-1]+events[i][2]);
//                }else {
//                    dp[i][j] = Math.max(dp[i-1][j],events[i][2]);
//                }

                int last = search(0, i - 1, events);
                if (last == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], events[i][2]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[last - 1][j - 1] + events[i][2]);
                }

            }
        }
        return dp[events.length - 1][k];
    }

    public int search(int left, int right, int[][] nums) {
        int target = nums[right + 1][0];
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid][1] < target) {
                left = mid + 1;
            } else if (nums[mid][1] >= target) {
                right = mid - 1;
            }
        }
        return left;
    }



    //回溯法 ： 超时
    int ans = 0;
    int K;
    int nums = 0  ;
    ArrayList<int[]> path = new ArrayList<>();
    int values=0;
    public int maxValue1(int[][] events, int k) {
        K = k;
        Arrays.sort(events,(o1,o2)->{
            return  o1[1]-o2[1];
        });
        backtracking(events,0);
        return  ans ;
    }
    public void backtracking(int[][] events,int start){
        if(nums==K && values <=ans){
            return;
        }
        if(nums<=K){
            ans = Math.max(ans,values);
        }
        for (int i = start; i < events.length; i++) {
            if( path.size()==0 || events[i][0] > path.get(path.size()-1)[1]) {
                path.add(events[i]);
                nums++;
                values+=events[i][2];
                backtracking(events,start+1);
                path.remove(path.size()-1);
                nums--;
                values-=events[i][2];
            }
        }
    }

    public static void main(String[] args) {
        int[][] events = new int[][]{{1,2,4},{3,4,3},{2,3,10}};
        new _1751().maxValue1(events,2);
    }

}

