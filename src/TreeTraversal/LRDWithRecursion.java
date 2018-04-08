package TreeTraversal;

/**
 * Created by jinchuyang on 2018/3/16.
 */
public class DRLWithRecursion implements Traverse{
    @Override
    public void traveral(TreeNode node){
        if (node.leftNode != null)
            traveral(node.leftNode);
        
        if (node.rightNode != null)
            traveral(node.rightNode);

        System.out.println(node.value);
    }
}
