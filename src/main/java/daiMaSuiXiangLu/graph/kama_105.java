package daiMaSuiXiangLu.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 有向图的完全可达性
 * 题目解读：
 * 思路：
 * 1.dfs/bfs
 * 2.注意有向图的节点的连接性
 * 优化：
 */
public class kama_105 {
   static int cnt ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//节点数
        int K = scanner.nextInt();//边数

        ArrayList<Integer>[] graph = new ArrayList[N+1];//图：领接表
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }
        //构造有向图
        for (int i = 0; i < K; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            graph[s].add(t);
        }
        boolean[] visited = new boolean[N+1];
        cnt = N;//没有被 visted的节点的个数
        visited[1]=true;
        cnt--;

        //bfs
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 0; i < graph[poll].size(); i++) {
                Integer integer = graph[poll].get(i);
                if (!visited[integer]) {
                    visited[integer] = true;
                    cnt--;
                    queue.add(integer);
                }
            }
        }


        //dfs
       // dfs(1, graph, visited);



        if (cnt==0){
            System.out.println("1");
        }else {
            System.out.println("-1");
        }
    }

    public static void dfs(int curKey, ArrayList<Integer>[] graph, boolean[] visited) {
        ArrayList<Integer> list = graph[curKey];
        for (int i = 0; i < list.size(); i++) {
            if (!visited[list.get(i)]) {
                visited[list.get(i)] = true;
                cnt--;
                dfs(list.get(i), graph, visited);
            }
        }
    }
}
