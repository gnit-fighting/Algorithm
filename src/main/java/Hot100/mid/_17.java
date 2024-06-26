package Hot100.mid;

import java.util.ArrayList;
import java.util.List;

public class _17 {
    StringBuilder path = new StringBuilder();
    List<String> result  = new ArrayList<>();
   final String[] strs=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits){
        if(digits.length()==0){
            return  result;
        }

        backtracking(digits,0);
        return  result;
    }

    public  void backtracking(String digits,int idx){

        if(idx==digits.length()){
            result.add(new String(path));
            return;
        }




        char[] charArray = strs[digits.charAt(idx)-'0'].toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            path.append(charArray[i]);
            backtracking(digits,idx+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
