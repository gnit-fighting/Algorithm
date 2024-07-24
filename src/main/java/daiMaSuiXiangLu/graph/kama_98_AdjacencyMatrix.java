package daiMaSuiXiangLu.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class kama_98_AdjacencyMatrix {
    static int[][] matrix;
    static int N;
    static boolean[] visited;//保存当前被访问过的节点
    //保存所有的路径（结果）
    static List<ArrayList<Integer>> result;

    //保存当前路径
    static ArrayList<Integer> path;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        visited = new boolean[N + 1];//0号节点不使用，节点为1-N
        int m = scanner.nextInt();
        result = new ArrayList<>();
        path = new ArrayList<>();

        matrix = new int[N + 1][N + 1];//第一行第一列的节点编号为 0，弃用
        //根据输入构建图的领结矩阵
        for (int i = 0; i < m; i++) {
            matrix[scanner.nextInt()][scanner.nextInt()] = 1;
        }

        //深度优先搜索
        path.add(1);
        dfs(1);

        if (result.size() == 0) {
            System.out.println(-1);
        }
        //处理result的打印
        for (ArrayList<Integer> res : result) {
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
                if (i != res.size() - 1) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }

    }

    /**
     * 领结矩阵的深度优先遍历
     *
     * @param n 当前处理的节点
     */
    public static void dfs(int n) {
        //终止条件
        if (n == N && path.size() != 0) {
            //收集结果
            result.add(new ArrayList<>(path));


            //返回
            return;
        }


        for (int i = 1; i <= N; i++) {
            //有从n到i的边
            if (matrix[n][i] == 1 && !visited[i]) {
                //访问节点
                visited[i] = true;
                path.add(i);

                //递归dfs
                dfs(i);

                //回溯
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
