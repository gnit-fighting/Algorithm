package Hot100.mid;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 验证二叉搜索树
 */
public class _98 {
    public boolean isValidBST0(TreeNode root) {
        if(root.left==null &&  root.right==null){
            return  true;
        }
        if(root.left ==null && root.right!=null){
            if(root.val < root.right.val){
                return  isValidBST(root.right);
            }else {
                return false;
            }
        }
        if(root.left !=null && root.right ==null){
            if(root.left.val < root.val){
                return  isValidBST(root.left);
            }else {
                return  false;
            }
        }
        if(!((root.left.val < root.val) &&(root.val < root.right.val) )){
            return  false;
        }

        return  isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        //二叉树搜索数的中序遍历序列是递增序列
        List<Integer> record  = new ArrayList<>();
        inorder(root,record);
        for (int i = 0; i < record.size()-1; i++) {
            if(record.get(i)  >= record.get(i+1)){
                return  false;
            }
        }

        return  true;
    }
    public  void inorder (TreeNode root, List<Integer> record){
        if(root==null){
            return;
        }
        inorder(root.left,record);
        record.add(root.val);
        inorder(root.right,record);
    }
}
