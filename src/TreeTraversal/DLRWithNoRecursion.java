package TreeTraversal;

import java.util.Stack;

/**
 * Created by jinchuyang on 2018/3/16.
 */

/**
 * 非递归的先序遍历，利用stack存中间节点
 */

public class DLRWithNoRecursion implements Traverse{

    @Override
    public void traveral(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tn = node;
       while(tn != null || !stack.empty()){
           if (tn == null){
               tn = stack.pop();
           }else {
               System.out.println(tn.value);
               if (tn.rightNode != null){
                   stack.push(tn.rightNode);
               }
               tn = tn.leftNode;
           }
       }
    }
}
