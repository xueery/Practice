package Practice0923;

/**
 * @author:wangxue
 * @date:2019/9/25 7:52
 */
public class TreeMain {
    public static void main(String[] args) {
        TraversalTree tree=new TraversalTree();
        TraversalTree.Node head=tree.buildTree();
        tree.preTraversal(head);
        System.out.println(tree.orderTraversal(head));
        tree.postTraversal(head);
    }
}
