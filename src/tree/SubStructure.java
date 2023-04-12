package tree;

public class SubStructure {

    private class TreeNode {
        public int val;
        public TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // return search(A, B);
        return compare(A, B)|isSubStructure(A.left, B)||isSubStructure(A.right, B);
    }

    // private boolean search(TreeNode A, TreeNode B) {
    //     if (A.val == B.val && compare(A, B)) {
    //         return true;
    //     }
    //     return search(A.left, B) || search(A.right, B);
    // }

    private boolean compare(TreeNode A, TreeNode B) {
        //先序遍历

        if(B==null){
            return true;
        }
        if(A==null){
            return false;
        }
        return A.val == B.val && compare(A.left, B.left) && compare(A.right, B.right);
    }

    public static void main(String[] args) {

    }

}
