package Hot100.mid;

/**
 * 颜色分类
 */
public class _75 {
    public void sortColors(int[] nums) {
        //统计 0、1，2的数量
        int cnt0 =0 ;
        int cnt1=0 ;
        int cnt2 = 0 ;
        for (int i :nums) {
            if(i==0){
                cnt0++;
                continue;
            }
            if(i == 1){
                cnt1 ++;
                continue;
            }
            cnt2++;
        }

        int k = 0 ;
        for (int i = 0; i < cnt0; i++) {
            nums[k++] =  0 ;
        }
        for (int i = 0; i < cnt1; i++) {
            nums[k++] = 1;

        }
        for (int i = 0; i <cnt2; i++) {
            nums[k++] = 2;
        }

    }
}
