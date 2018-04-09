package TreeTraversal;

import java.util.Stack;

/**
 * Created by jinchuyang on 2018/3/16.
 */

/**
 * 非递归的中序遍历，利用stack存中间节点
 */

public class LDRWithNoRecursion implements Traverse{
    //非递归实现
    //根据中序遍历的顺序，对于任意节点，优先访问其左孩子，而左孩子节点又可以看做一根节点，然后继续访问左孩子节点为空的节点才进行
    //访问，然后按相同的规则访问其右子树。因此其处理过程如下：
    //（1）对于任意节点其左孩子不为空，则将P入栈并将P的左孩子置为当前的P，然后对当前节点P再进行相同的处理
    //（2）若其左孩子不为空，则取栈顶元素并进行出栈操作，访问该栈顶节点，然后将当前的P置为栈顶节点的右孩子
    //（3）直到P为NULL并且栈为空则遍历结束
    @Override
    public void traveral(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tn = node;
        while (!stack.empty() || tn != null) {
            while (tn != null) {
                stack.push(tn);
                tn = tn.leftNode;
            }

            if (!stack.empty()) {
                tn = stack.pop();
                System.out.println(tn.value);
                //stack.pop();
                tn = tn.rightNode;
            }

        }
    }
}
