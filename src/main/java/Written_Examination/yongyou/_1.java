package Written_Examination.yongyou;

public class _1 {
    public long minOperations (int[] nums1, int[] nums2, int k) {
        // write code here
        long ans = 0L;
        boolean success = true;
        long sum1 = 0L; //两个数组的和必须相同，才符合条件
        long sum2 = 0L;

        for (int i = 0; i < nums1.length; i++) {
            sum1+=nums1[i];
            sum2+=nums2[i];

            if(nums1[i] == nums2[i]){
                continue;
            }
            if(nums1[i] > nums2[i]){
                //nums1[i] 大
                int temp = nums1[i] - nums2[i];
                if(temp % k ==0){
                    ans += (temp/k);
                }else {
                    success = false;
                }
            }else {
                //nums2[i] 大
                int temp = nums2[i] - nums1[i];
                if(temp % k ==0){
                    ans += (temp/k);
                }else {
                    success = false;
                }
            }
        }
        if(sum2==sum1 && success){
            return ans/2;
        }else {
            return  -1L;
        }

    }
}
