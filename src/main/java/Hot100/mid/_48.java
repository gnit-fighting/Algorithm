package Hot100.mid;

/**
 * 旋转图像
 */
public class _48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];//临时存储旋转后的数组
        //第 0 行 -》 第 n-1列
        //。。。
        //第 n-1 行 -》 第 0 列
        for (int i = n-1; i >=0 ; i--) {
            int[] matrix1 = matrix[i];
            for (int j = 0; j < n; j++) {
                temp[j][n-1-i] = matrix1[j];
            }
        }

        //给原数组赋值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}
