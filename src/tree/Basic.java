package tree;

import java.util.ArrayList;
import java.util.*;;

public class Basic {

    private class TreeNode{
        public int val;
        public TreeNode left,right;
        TreeNode(int x){
            val=x;
        }
    }

    // 前序位置的代码在刚刚进入一个二叉树节点的时候执行；
    // 后序位置的代码在将要离开一个二叉树节点的时候执行；
    // 中序位置的代码在一个二叉树节点左子树都遍历完，即将开始遍历右子树的时候执行。

    public void traverse(TreeNode root){
        if(root==null){
            return;
        }
        //前序位置
        traverse(root.left);
        //中序位置
        traverse(root.right);
        //后序位置
    }

    //二叉树最大深度
    int res=0;
    int depth=0;
    int maxDepth(TreeNode root){
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root){
        if(root==null){
            return;
        }
        depth++;
        if(root.left==null&&root.right==null){
            res=Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }

    //二叉树的前序遍历
    List<Integer> preorder(TreeNode root){
        List<Integer> res=new LinkedList<>();
        if(root==null){
            return res;
        }
        res.add(root.val);
        res.addAll(preorder(root.left));
        res.addAll(preorder(root.right));

        return res;
    }

    // 前序位置的代码只能从函数参数中获取父节点传递来的数据，而后序位置的代码不仅可以获取参数数据，还可以获取到子树通过函数返回值传递回来的数据。
    
}
