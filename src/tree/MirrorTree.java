package tree;

public class MirrorTree {
    private class TreeNode{
        public int val;
        public TreeNode left,right;
        TreeNode(int x){
            val=x;
        }
    }


    public TreeNode solution(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode newRoot=new TreeNode(root.val);
        mirror(root, newRoot);
        return newRoot;
    }

    public void mirror(TreeNode root,TreeNode newRoot){
        if(root==null){
            return;
        }
        if(root.left!=null){
            newRoot.right=new TreeNode(root.left.val);
        }
        if(root.right!=null){
            newRoot.left=new TreeNode(root.right.val);
        }
        mirror(root.left, newRoot.right);
        mirror(root.right, newRoot.left);
    }
}
