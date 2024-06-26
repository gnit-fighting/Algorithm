package Hot100.mid;

/**
 * 二叉搜索树的第 k 小的元素
 */
public class _230 {
    int ans  = 0 ;
    int K;
    public int kthSmallest(TreeNode root, int k) {
        //中序遍历，秒了
        K = k;
        inorder(root);

        return  ans;

    }
    public  void inorder(TreeNode root){
        if(K<=0){
            return;
        }
        if(root == null) {
             return;
        }
        inorder(root.left);
        if(--K==0){
            ans = root.val;
            return;
        }
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node1 = new TreeNode(1, null, node2);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node1, node4);

        int i = new _230().kthSmallest(node3, 1);



    }
}
