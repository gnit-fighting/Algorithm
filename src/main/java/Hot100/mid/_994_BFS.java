package Hot100.mid;

import java.util.ArrayList;
import java.util.List;

public class _994_BFS {

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //统计一开始就腐烂的橘子 + 新鲜的橘子（用于判断最后是否有永远不被腐烂的橘子）
        int fresh = 0;
        List<int[]> queue = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int ans = -1;
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            ans++;

            List<int[]> temp = queue;
            queue = new ArrayList<>();
            for (int[] ints : temp) {
                for (int i = 0; i < 4; i++) {
                    int nextX = ints[0] + directions[i][0];
                    int nextY = ints[1] + directions[i][1];

                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                        continue;
                    }

                    if (grid[nextX][nextY] == 1) {
                        //腐烂这个新鲜的橘子
                        grid[nextX][nextY] = 2;
                        fresh--;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        return fresh >0 ? -1 : Math.max(ans, 0);

    }
}
