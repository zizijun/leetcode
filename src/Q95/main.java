package Q95;

import Q109.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jinchuyang on 2018/1/24.
 */
public class main {
    public List<TreeNode> generateTrees(int n) {
        if(n <= 0){
            List<TreeNode> list = new ArrayList<TreeNode>();
            return list;
        }

        TreeNode tr = new TreeNode(1);
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(tr);
        if(n == 1) return list;
        Map<Integer, List<TreeNode>> map= new HashMap<>();
        map.put(0, null);
        map.put(1, list);

        for(int i = 2; i <= n; i++){
            list = new ArrayList<TreeNode>();
            for(int j = 1; j <= i; j ++){
                List<TreeNode> list1 = map.get(j - 1);
                List<TreeNode> list22 = map.get(i - j);
                if(list22 == null){
                    for(TreeNode node : list1){
                        TreeNode no = new TreeNode(j);
                        no.left = node;
                        no.right = null;
                        list.add(no);
                    }
                    continue;
                }
                List<TreeNode> list2 = trans(list22, j);
                if(list1 == null){
                    for(TreeNode node : list2){
                        TreeNode no = new TreeNode(j);
                        no.left = null;
                        no.right = node;
                        list.add(no);
                    }
                    continue;
                }

                for(TreeNode no1 : list1){
                    for(TreeNode no2 : list2){
                        TreeNode no = new TreeNode(j);
                        no.left = no1;
                        no.right = no2;
                        list.add(no);
                    }
                }
            }
            map.put(i, list);
        }
        return map.get(n);
    }
    private List<TreeNode> trans(List<TreeNode> list, int n){
        List<TreeNode> newList = new ArrayList<TreeNode>();
        for(TreeNode node : list){
            TreeNode newNode = clone(node ,n);//难点，不能直接深度遍历修改，这样整个对象都会被改变，需要深度clone，返回新的TreeNode结点
            newList.add(newNode);
        }
        return newList;
    }
    private static TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}
