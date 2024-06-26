package Hot100.mid;

/**
 * 寻找重复数
 */
public class _287 {
    public int findDuplicate(int[] nums) {
        //二分法
        int l,r;
        l = 1;
        r = nums.length-1;
        int mid ;
        while (l<=r){
            mid = l + ((r-l)>>1);
            int cnt = 0 ;

            for (int i :nums) {
                if(i<=mid){
                    cnt++;
                }
            }
            if(cnt>mid){
                r= mid-1;
            }else {
                l = mid+1;
            }
        }
        return  l ;
    }
}
