package Hot100.mid;

import java.util.*;

/**
 * 矩阵置0
 */
public class _73 {

    //空间复杂度 O(mn)
    public void setZeroes2(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        int row;
        int col;
        Iterator<int[]> iterator = list.iterator();
        while (iterator.hasNext()) {
            int[] record = iterator.next();
            row = record[0];
            col = record[1];
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }

        }
    }

    //改进：空间复杂度O(m+n)
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> row0_set = new HashSet<>();
        Set<Integer> col0_set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row0_set.add(i);
                    col0_set.add(j);

                }
            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row0_set.contains(i) || col0_set.contains(j)) {
                    matrix[i][j] = 0;
                }

            }
        }
    }


    //改进：O(1)空间复杂度
    public void setZeroes(int[][] matrix) {
        //利用第一行和第一列作为标志位
        //第一行和第一列需要另设置标志位
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row0_flag = false;
        boolean col0_flag = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0_flag = true;
                break;
            }

        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0_flag = true;
                break;
            }

        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

            }

        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }

            }

        }
        if (row0_flag) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;

            }
        }
        if (col0_flag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }


    }


}
