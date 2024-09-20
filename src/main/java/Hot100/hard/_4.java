package Hot100.hard;

/**
 * 寻找两个正序数组的中位数
 */
public class _4 {
    public static void main(String[] args) {
        //[6,7,8,9,10,11,12,13,14,15,16,17]
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {6,7,8,9,10,11,12,13,14,15,16,17};
        System.out.println(new _4().findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //1.T(n) = O(m+n)
        int m = nums1.length;
        int n = nums2.length;

        int idx = 0;
        int ans=0 ;
        if ((m+n)%2==0) {
            int i =0,j=0 ;
            for ( i = 0,j = 0; i <m &&j<n ;) {
                if (nums1[i] <=nums2[j]) {
                    if (idx==(m+n)/2 || idx==((m+n)/2)-1) {
                        ans += nums1[i];
                    }
                    i++;
                    idx++;
                }else {
                    if (idx==(m+n)/2 || idx==(m+n)/2-1) {
                        ans += nums2[j];
                    }
                    j++;
                    idx++;
                }
            }
            while (i<m){
                if (idx==(m+n)/2 || idx==((m+n)/2)-1) {
                    ans += nums1[i];
                }
                i++;
                idx++;
            }
            while (j<n){
                if (idx==(m+n)/2 || idx==(m+n)/2-1) {
                    ans += nums2[j];
                }
                j++;
                idx++;
            }
            return ans/2.0;
        }else{
            int i=0,j=0;
            for ( i = 0,j = 0; i <m &&j<n ;) {
                if (nums1[i] <=nums2[j]) {
                    if (idx==(m+n)/2) {
                        ans = nums1[i];
                    }
                    i++;
                    idx++;
                }else {
                    if (idx==(m+n)/2 ) {
                        ans = nums2[j];
                    }
                    j++;
                    idx++;
                }
            }
            while (i<m){
                if (idx==(m+n)/2) {
                    ans = nums1[i];
                }
                i++;
                idx++;
            }
            while (j<n){
                if (idx==(m+n)/2) {
                    ans = nums2[j];
                }
                j++;
                idx++;
            }
            return ans;
        }





    }
}
