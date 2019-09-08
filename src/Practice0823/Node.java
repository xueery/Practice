package Practice0823;

public class Node {
    char value;
    Node left=null;
    Node right=null;
    Node(char value){
        this.value=value;
    }
    Node(char value,Node left,Node right){
        this(value);
        this.left=left;
        this.right=right;
    }
}
