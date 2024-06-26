package Hot100.mid;

/**
 * 搜索二维矩阵
 */
public class _74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //二维矩阵的二分
        //要点：对 i，j 进行下标的映射（映射到一维）
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        int mid;
        int i, j; //记录一维下标 mid 对应的二维下标
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            j = mid % n;
            i = mid / n;
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                r = mid - 1;
            }
            if (matrix[i][j] < target) {
                l = mid + 1;
            }
        }
        return false;
    }
}
