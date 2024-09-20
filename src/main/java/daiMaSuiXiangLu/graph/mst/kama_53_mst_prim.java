package daiMaSuiXiangLu.graph.mst;

import java.util.Scanner;

/**
 * 最小生成树 - prim 算法（核心思想：取 minDist、更新 minDist）
 */
public class kama_53_mst_prim {
    public static void main(String[] args) {
        int[][] graph = new int[10001][10001];
        for (int i = 0; i < 10001; i++) {
            for (int j = 0; j < 10001; j++) {
                graph[i][j] = 10001;
            }
        }
        int[] minDist = new int[10001];
        for (int i = 0; i < 10001; i++) {
            minDist[i] = 10001;
        }
        boolean[] isInMST = new boolean[10001];//是否在生成树中
        int[] parent = new int[10001];//记录最小生成树的边（parent 虽有有向边的意思，这里还是用它吧，理解成两个节点的连接就行）


        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();//节点数
        int E = scanner.nextInt();//边数
        for (int i = 0; i < E; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int weight = scanner.nextInt();
            graph[v1][v2] = weight;
            graph[v2][v1] = weight;
        }


        isInMST[1] = true;//不妨以 1 为起点
        for (int i = 2; i <= V; i++) {
            if (!isInMST[i] &&  graph[1][i] < minDist[i]) {
                minDist[i] = graph[1][i];
            }
        }
        for (int i = 1; i <= V - 1; i++) {
            //1.获取 minDist 最小的节点
            int min = 10001;
            int curV = 0;
            for (int j = 2; j <= V; j++) {
                if (!isInMST[j] && minDist[j] < min) {
                    min = minDist[j];
                    curV = j;
                }
            }

            //2. 加入生成树
            isInMST[curV] = true;

            //3. 更新 minDist
            for (int j = 1; j <=V ; j++) {
                if (!isInMST[j] && graph[curV][j] < minDist[j]) {
                    minDist[j] = graph[curV][j];
                    //记录最小生成树的边
                    //为啥不能写成 parent[curV] = j;？ 因为这样每次只是跟新了 cur 和 最后一个 j 的那条边
                    //为什么在这里记录生成树的边？最后更新 minDist[j] 的，一定是在生成树的；更新多次没关系，最终只记录最后一次更新，也就是最小生成树的边
                    parent[j] = curV;
                }
            }
        }

        //此时 minDist[2] - minDist[V] 的和就是最小生成树的权重和（V 个节点 V-1条边）
        //1 是起点
        int result = 0 ;
        for (int i = 2; i <=V ; i++) {
            result += minDist[i];
        }
        System.out.println(result);
    }
}
