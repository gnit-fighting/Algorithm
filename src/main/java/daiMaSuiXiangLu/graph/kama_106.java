package daiMaSuiXiangLu.graph;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 岛屿的周长
 * 题目解读：
 * 思路：
 * 1.dfs/bfs
 * 2.注意一边遍历岛屿，一边判断当前节点是不是边界，边界则计算（累加）周长
 * 优化：
 * 1.只需要在计算出相邻岛屿的数量就可以了，相邻岛屿数量为cover。
 * 2.结果 result = 岛屿数量 * 4 - cover * 2;
 */
public class kama_106 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//矩阵行数
        int M = scanner.nextInt();//矩阵列数
        int[][] grid = new int[N][M];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean addFirst = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = scanner.nextInt();
                if (grid[i][j] == 1 && !addFirst) {
                    addFirst=true;
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 2;//标记已访问过
                }
            }
        }

        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int circumference = 0 ;//周长
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];

            //考虑是不是边界节点，边界节点则计算周长
            for (int i = 0; i < 4; i++) {
                int nextX = curX + directions[i][0];
                int nextY = curY + directions[i][1];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M ||grid[nextX][nextY] == 0) {
                    circumference++;
                    continue;
                }

                if (grid[nextX][nextY] == 2) {
                    continue;
                }
                //当前节点是陆地
                grid[nextX][nextY] = 2;//标记已访问过
                queue.offer(new int[]{nextX, nextY});
            }
        }
        System.out.println(circumference);
    }
}
