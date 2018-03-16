package TreeTraversal;

/**
 * Created by jinchuyang on 2018/3/16.
 */
public class LDRWithRecursion {
    void traveral(TreeNode node){
        if (node.leftNode != null)
            traveral(node.leftNode);

        System.out.println(node.value);
        
        if (node.rightNode != null)
            traveral(node.rightNode);
    }
}
