package TreeTraversal;

import java.util.Stack;

/**
 * Created by jinchuyang on 2018/3/16.
 */

/**
 * 非递归的后序遍历，利用stack存中间节点
 */

public class LRDWithNoRecursion implements Traverse{
    /*
    后序遍历递归定义：先左子树，后右子树，再根节点。
    后序遍历的难点在于：需要判断上次访问的节点是位于左子树，还是右子树。
        若是位于左子树，则需跳过根节点，先进入右子树，再回头访问根节点；
        若是位于右子树，则直接访问根节点。
     */

    @Override
    public void traveral(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tn = node;
        TreeNode lastVisitNode = null;
        while(tn != null){
            stack.push(tn);
            tn = tn.leftNode;
        }
        while (!stack.empty()){
            tn = stack.pop();
            //一个根节点被访问的前提是：无右子树或右子树已被访问过
            if(tn.rightNode != null && tn.rightNode != lastVisitNode){
                stack.push(tn);
                tn = tn.rightNode;
                while(tn != null){
                    stack.push(tn);
                    tn = tn.leftNode;
                }

            }else {
                System.out.println(tn.value);
                lastVisitNode = tn;
            }


        }

    }
}
