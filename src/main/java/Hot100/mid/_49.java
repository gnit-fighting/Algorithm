//package Hot100.mid;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//
//public class _49 {
//    //字母仪位词
//    public List<List<String>> groupAnagrams(String[] strs) {
//        //字母异位词：对字符排序后相同
//        //遍历 strs，排序 str，对 排序后相同的 str放到同一个 key 的 value 中
//        HashMap<String, List<String>> map = new HashMap<>();
//        if(strs==null){
//            return  null;
//        }
//        for (int i = 0; i < strs.length; i++) {
//            char[] charArray = strs[i].toCharArray();
//            Arrays.sort(charArray);
//            //char[] 数组的 toString() 方法返回的是数组对象的地址值的字符串表示形式，而不是数组中的内容！！！
//           // String key = charArray.toString();
//
//            String key=  new String(charArray);
//            map.computeIfAbsent(key, k-> new ArrayList<>()).add(strs[i]);
//        }
//
//        return  map.values().stream().toList();
//
//    }
//}
