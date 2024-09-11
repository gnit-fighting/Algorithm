package Hot100.mid;

/**
 * 腐烂的橘子
 * 思路：
 * 1. 暴力-循环遍历，每次遍历处理一轮腐烂
 * 2.【优化】BFS
 */
public class _994 {
    public static void main(String[] args) {
        // [[2,1,1],[1,1,0],[0,1,1]]
        int[][] gird = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        orangesRotting(gird);

    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int minMinute = 0;

        while (true) {
            boolean b = makeRotten(grid);
            minMinute++;
            if (b == false) {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length; j++) {
                        if (grid[i][j] == 1) {
                            return -1;
                        }
                    }
                }
                return minMinute - 1;
            }
        }
    }

    //遍历（这一分钟），腐烂橘子将周围的搞腐烂
    static int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static boolean makeRotten(int[][] gird) {
        boolean incr = false;
        boolean[][] exclued = new boolean[gird.length][gird[0].length];
        for (int i = 0; i < gird.length; i++) {
            for (int j = 0; j < gird[0].length; j++) {
                if (!exclued[i][j] && gird[i][j] == 2) {
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + directions[k][0];
                        int nextY = j + directions[k][1];

                        if (nextX < 0 || nextX >= gird.length || nextY < 0 || nextY >= gird[0].length) {
                            continue;
                        }
                        if (gird[nextX][nextY] == 1) {
                            gird[nextX][nextY] = 2;
                            //新腐烂的本轮 exclude 掉
                            exclued[nextX][nextY] = true;
                            incr = true;
                        }
                    }
                }

            }
        }
        return incr;
    }
}
