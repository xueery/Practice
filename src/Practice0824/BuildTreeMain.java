package Practice0824;

import java.util.Arrays;
import java.util.List;

public class BuildTreeMain {
    public static void main(String[] args) {
        MadeTree tree=new MadeTree();
        List<Character> preorder= Arrays.asList('A','B','D','E','G','C','F','H');
        List<Character> inorder=Arrays.asList('D','B','G','E','A','C','F','H');
        List<Character> postorder=Arrays.asList('D','G','E','B','H','F','C','A');
        Node root1=tree.madeTree1(preorder,inorder);
        Node root2=tree.madeTree2(inorder,postorder);
        System.out.println("successful");
    }
}
