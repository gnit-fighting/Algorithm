package other;

import java.util.*;

/**
 * 单词接龙
 */
public class _127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> strSet = new HashSet<>();
        for (String s : wordList) {
            strSet.add(s);
        }
        if (!strSet.contains(endWord)) {
            return 0;
        }

        boolean find = false;
        ArrayDeque<String> queue = new ArrayDeque<>();
        HashMap<String, Integer> visited = new HashMap<>();//k:节点  v：步数
        queue.offer(beginWord);//从beginStr出发
        visited.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            //把 cur 节点邻居入队
            Integer step = visited.get(poll);

            for (int i = 0; i < poll.length(); i++) {
                char[] charArray = poll.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    charArray[i] = j;
                    String newStr = new String(charArray);
                    if (newStr.equals(endWord)) {
                        visited.put(endWord, step + 1);
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

        return find ? visited.get(endWord) : 0;
    }

}
