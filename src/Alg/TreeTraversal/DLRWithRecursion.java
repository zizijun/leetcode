package TreeTraversal;

/**
 * Created by jinchuyang on 2018/3/16.
 */
public class DLRWithRecursion implements Traverse{
    @Override
    public void traveral(TreeNode node){
        System.out.println(node.value);
        if (node.leftNode != null)
            traveral(node.leftNode);
        
        if (node.rightNode != null)
            traveral(node.rightNode);
    }
}
