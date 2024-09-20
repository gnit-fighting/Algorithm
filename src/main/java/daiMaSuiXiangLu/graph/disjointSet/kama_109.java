package daiMaSuiXiangLu.graph.disjointSet;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 冗余连接II
 * 思路：
 * 1.并查集的应用
 * 总结：
 * 注意细节！本题我调试了好久
 */
public class kama_109 {
    static int[] father = new int[1001];

    static void init(int N) {
        for (int i = 1; i <= N; i++) {
            father[i] = i;
        }
    }

    static int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return find(father[x]);//不压缩路径
    }


    static boolean isSame(int x, int y) {
        return find(x) == find(y);
    }

    static void join(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx != fy) {
            father[fx] = fy;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//有向图中节点和边的个数
        if (N == 1) {
            System.out.println("1 1");
            return;
        }

        ArrayList<Integer>[] ruDu = new ArrayList[N + 1];//入度(节点为 1-N)
        for (int i = 0; i < N + 1; i++) {
            ruDu[i] = new ArrayList<>();
        }
        ArrayList<int[]> bian = new ArrayList<>(N + 1);//边（int[0] -> int[1]）
        int rudu2 = 0;//存储入度为 2 的节点（如果有）
        for (int i = 0; i < N; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();

            ruDu[t].add(i);
            bian.add(new int[]{s, t});

            if (ruDu[t].size() == 2) {
                rudu2 = t;
            }
        }
        if (rudu2 != 0) {
            //某个节点的入度为 2 ，冗余边肯定在连接该节点的其中一条边，找出该边，删除之，输出，返回
            // 若多条边可删除，优先删除最后出现的，故倒序遍历当前出现的边
            boolean flag = true;
            for (int j = 1; j >= 0; j--) {
                int skip = ruDu[rudu2].get(j);//bian 要跳过的下标

                init(N);
                for (int k = 0; k < bian.size(); k++) {
                    int[] curBian = bian.get(k);
                    if (skip != k) {
                        if (isSame(curBian[0], curBian[1])) {
                            flag = false;
                            break;
                        } else {
                            join(curBian[0], curBian[1]);
                            if (k == bian.size() - 1) {
                                flag = true;
                            }
                        }
                    }
                }
                if (flag) {
                    System.out.println(bian.get(skip)[0] + " " + bian.get(skip)[1]);
                    return;
                }
            }
        }

        //走到这，所有节点的入度都为 1 ，有节点构成一个环，
        // 删除环的任何一条边，剩余的边都能构成有向树
        // 故有多条边可以删除，输出环中最后出现的边即可
        init(N);
        for (int k = 0; k < bian.size(); k++) {
            int[] curBian = bian.get(k);
            if (isSame(curBian[0], curBian[1])) {
                System.out.println(curBian[0] + " " + curBian[1]);
                break;
            } else {
                join(curBian[0], curBian[1]);
            }
        }
    }
}
