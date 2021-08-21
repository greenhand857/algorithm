package LeetCodeHot100;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _094_InorderTraversal {
    // 二叉树的中序遍历
    private List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        // process(root);
        // return res;
        if(root != null){
            Stack<TreeNode> stack = new Stack<>();
            while(root != null || !stack.isEmpty()){
                if(root != null){
                    stack.push(root);
                    root = root.left;
                }else{
                    root = stack.pop();
                    res.add(root.val);
                    root = root.right;
                }
            }
        }
        return res;
    }

    // 递归实现中序遍历 process(root); return res;
     public void process(TreeNode root){

         if(root == null) return;
         process(root.left);
         res.add(root.val);
         process(root.right);

     }
}
