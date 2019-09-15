package Practice0825;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        Node root = s.build();
        System.out.println(s.calHeight(root));
        System.out.println(s.isBalanced(root));
        Node ret = s.lowestCommonAncestor(root, root, root);
        if (ret != null) {
            System.out.printf("%c%n", ret.val);
        }
        System.out.println(s.search(root, root));
        s.levelOrderTraversal(root);
        System.out.println(s.treestr(root));
    }
}
