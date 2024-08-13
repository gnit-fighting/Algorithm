package daiMaSuiXiangLu.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 建造最大的岛屿
 * 题目解读：修改一个 0 为 1 后，求最大的岛屿面积
 * 思路：
 * 1.第一遍遍历：统计每个岛屿的面积
 * 2.第二遍遍历矩阵，尝试把一个 0 变成 1，统计当前的岛屿面积，更新最大岛屿面积
 * 优化：
 */
public class kama_104 {
    static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] grid;
    static ArrayDeque<int[]> queue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//行数
        int M = scanner.nextInt();//列数

        grid = new int[N][M];//图

        //读取输入的图
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }


        //第一遍遍历，记录每个岛屿的面积
        int markNum = 2;
        int maxArea = 0;
        HashMap<Integer, Integer> islandArea = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    int dfsArea = dfs(i, j, markNum, 0);
                    islandArea.put(markNum, dfsArea);
                    markNum++;
                    maxArea = Math.max(maxArea, dfsArea);
                }
            }
        }

        int curChangeArea = 0;
        //第二遍遍历，尝试替换 0->1，统计最大面积
        HashSet<Integer> islandSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0) {
                    //考虑合并周围的岛屿
                    curChangeArea = 1;//当前节点 0->1
                    //用 set 存储周围的岛屿，因为可能四个方向是同一块岛屿，保证同一块岛屿只计算一次
                    //上
                    if (i - 1 >= 0 && grid[i - 1][j] > 0) {
                        islandSet.add(grid[i - 1][j]);
                    }
                    //下
                    if (i + 1 < N && grid[i + 1][j] > 0) {
                        islandSet.add(grid[i + 1][j]);
                    }
                    //左
                    if (j - 1 >= 0 && grid[i][j - 1] > 0) {
                        islandSet.add(grid[i][j - 1]);
                    }
                    //右
                    if (j + 1 < M && grid[i][j + 1] > 0) {
                        islandSet.add(grid[i][j + 1]);
                    }
                    for (Integer island : islandSet) {
                        curChangeArea += islandArea.get(island);
                    }
                    maxArea = Math.max(maxArea, curChangeArea);
                    islandSet.clear();
                }

            }
        }

        //输出结果
        System.out.println(maxArea);
    }

    /**
     * 深度优先遍历
     *
     * @param curX    当前准备遍历的节点
     * @param curY
     * @param markNum 该岛屿标记（标记为大于 1 的数字）
     */
    public static int dfs(int curX, int curY, int markNum, int area) {
        if (curX < 0 || curX >= grid.length || curY < 0 || curY >= grid[0].length || grid[curX][curY] != 1) {
            return area;
        }
        grid[curX][curY] = markNum;
        area++;
        for (int i = 0; i < 4; i++) {
            int nextX = curX + dir[i][0];
            int nextY = curY + dir[i][1];

            area = dfs(nextX, nextY, markNum, area);
        }
        return area;
    }
}
