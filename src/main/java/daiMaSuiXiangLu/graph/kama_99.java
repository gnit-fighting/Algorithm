package daiMaSuiXiangLu.graph;

import java.util.Scanner;

/**
 * 岛屿数量-dfs
 */
public class kama_99 {
    static int[][] grid;
    static boolean[][] visited;
    static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//行数
        int M = scanner.nextInt();//列数

        grid = new int[N][M];//图
        visited = new boolean[N][M];
        int ans = 0 ;//统计结果

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ans++;
                    visited[i][j] = true;
                    dfs(i, j);
                }
            }
        }

        System.out.println(ans);
    }

    public static void dfs(int curX, int curY) {

        for (int i = 0; i < 4; i++) {
            int nextX = curX + dir[i][0];
            int nextY = curY + dir[i][1];

            if (nextX < 0 || nextX >= grid.length || nextY < 0|| nextY >= grid[0].length) {
                continue;
            }
            if (!visited[nextX][nextY]&&grid[nextX][nextY] == 1) {
                //访问该节点
                visited[nextX][nextY] = true;
                dfs(nextX, nextY);
            }
        }
    }
}
