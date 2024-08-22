package daiMaSuiXiangLu.graph;


import java.util.*;

/**
 * 字符串接龙
 * 题目解读：求 beginStr 到 endStr 的最短路（中间字符只能是字典 strList 中的字符）；
 * 和leetcode127 类似
 * 思路：
 * 优化：
 * 1.构造图的方案超时，优化成不构造图，仅对队列的元素判断替换后的字符串能不能在字典中找到即可(即不需要构造全局的图)
 */
public class kama_110 {
    public static void main(String[] args) {
        //获取输入
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); //字典中字符串的数量
        String beginStr = null;
        String endStr = null;
        HashSet<String> strSet = new HashSet<>();
        beginStr = scanner.next();
        endStr = scanner.next();
        for (int i = 0; i < N; i++) {
            strSet.add(scanner.next());
        }


        //bfs
        //节点（字符串）之间的连通性：字符串 1 替换了某个位置的字符后等于字符串 2
        boolean find = false;
        ArrayDeque<String> queue = new ArrayDeque<>();
        HashMap<String, Integer> visited = new HashMap<>();//k:节点  v：步数
        queue.offer(beginStr);//从beginStr出发
        visited.put(beginStr, 1);
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            Integer step = visited.get(poll);

            //把 cur 节点邻居入队
            for (int i = 0; i < poll.length(); i++) {
                char[] charArray = poll.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    charArray[i] = j;
                    String newStr = new String(charArray);
                    if (newStr.equals(endStr)) {
                        visited.put(endStr, step + 1);
                        find = true;
                        break;
                    }
                    if (strSet.contains(newStr) && !visited.containsKey(newStr)) {
                        queue.offer(newStr);
                        visited.put(newStr, step + 1);
                    }
                }
            }
            if (find) {
                break;
            }
        }

        //输出
        System.out.println(visited.get(endStr));
    }


}
