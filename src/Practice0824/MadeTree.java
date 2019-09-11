package Practice0824;

import java.util.List;

public class MadeTree {
    //前序+中序构建树
    // 用顺序表
    public Node madeTree1(List<Character> preorder, List<Character> inorder) {
        if (preorder.size() == 0) {
            return null;
        }
        char rootValue = preorder.get(0);
        int leftCount = inorder.indexOf(rootValue);
        Node root = new Node(rootValue);
        List<Character> leftpreorder = preorder.subList(1, leftCount + 1);
        List<Character> leftInorder = inorder.subList(0, leftCount);
        Node left = madeTree1(leftpreorder, leftInorder);
        root.left = left;
        List<Character> rightpreorder = preorder.subList(leftCount + 1, preorder.size());
        List<Character> rightinorder = inorder.subList(leftCount + 1, inorder.size());
        Node right = madeTree1(rightpreorder, rightinorder);
        root.right = right;
        return root;
    }

    //中序+后序构建树
    public Node madeTree2(List<Character> inorder, List<Character> postorder) {
        if (inorder.size() == 0) {
            return null;
        }
        char rootValue = postorder.get(postorder.size() - 1);
        int leftCount = inorder.indexOf(rootValue);
        Node root = new Node(rootValue);
        List<Character> leftinorder = inorder.subList(0, leftCount);
        List<Character> leftpostorder = postorder.subList(0, leftCount);
        Node left = madeTree2(leftinorder, leftpostorder);
        root.left = left;
        List<Character> rightinorder = inorder.subList(leftCount + 1, inorder.size());
        List<Character> rightpostorder = postorder.subList(leftCount, postorder.size() - 1);
        Node right = madeTree2(rightinorder, rightpostorder);
        root.right = right;
        return root;
    }
}