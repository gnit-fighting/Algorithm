package daiMaSuiXiangLu.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class kama_98_AdjacencyTable {
     static  int N;//节点数
    static int M ;//边数
    static ArrayList<ArrayList<Integer>> result;
    static ArrayList<Integer> path;
    static  ArrayList<ArrayList<Integer>> matrix;
    static  boolean[] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        matrix = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) {
            matrix.add(new ArrayList<>());
        }
        result = new ArrayList<>();
        path = new ArrayList<>();
        visited = new boolean[N+1];


        int s,t;
        for (int i = 0; i <M ; i++) {
            s = scanner.nextInt();
            t = scanner.nextInt();
            matrix.get(s).add(t);
        }

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
    public  static  void dfs(int idx){
        if(idx == N){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < matrix.get(idx).size(); i++) {
            if (!visited[matrix.get(idx).get(i)]) {
                path.add(matrix.get(idx).get(i));
                visited[matrix.get(idx).get(i)]=true;

                dfs(matrix.get(idx).get(i));

                visited[matrix.get(idx).get(i)]=false;
                path.remove(path.size()-1);
            }
        }
    }
}
