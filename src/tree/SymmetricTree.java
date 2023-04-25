package tree;

public class SymmetricTree {

    private class TreeNode{
        public int val;
        public TreeNode left,right;
        TreeNode(int x){
            val=x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return recur(root.left, root.right);
    }

    public static boolean recur(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }

        return left.val==right.val&&recur(left.left, right.right)&&recur(left.right, right.left);

    }


    public static void main(String[] args) {
        
    }
    
}
