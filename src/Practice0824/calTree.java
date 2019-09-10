package Practice0824;

public class calTree {
    public static Node buileTree1() {
            Node a = new Node('A');
            Node b = new Node('B');
            Node c = new Node('C');
            Node d = new Node('D');
            a.left=b;
            b.left=d;
            a.right=c;
            return a;
    }
    public static Node buildTree2(){
        Node a=new Node('A');
        Node b=new Node('B');
        Node c=new Node('C');
        Node d=new Node('D');
        a.left=b;
        b.left=d;
        a.right=c;
        return a;
    }
    public static Node buildTree3(){
        Node a=new Node('A');
        Node b=new Node('B');
        Node c=new Node('C');
        Node d=new Node('D');
        a.left=c;
        a.right=b;
        b.right=d;
        return a;
    }
    public static Node buildTree4(){
        Node b=new Node('B');
        Node d=new Node('D');
        b.left=d;
        return b;
    }
    //计算叶子结点的个数
    //遍历的思想
    public static int count=0;
    public static void calLeftCount1(Node root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
          count++;
        }
        calLeftCount1(root.left);
        calLeftCount1(root.right);
    }
    //计算第K层的结点
    //汇总思想
    public static int calKCount(Node root,int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        int left=calKCount(root.left,k-1);
        int right=calKCount(root.right,k-1);
        int sum=left+right;
        return sum;
    }
    //求树的高度
    public static int calHeight(Node root){
        if(root==null){
            return 0;
        }
        int left=calHeight(root.left);
        int right=calHeight(root.right);
        int height=Math.max(left,right)+1;
        return height;
    }
    //查找
    public static Node search(Node root,int val){
        if(root==null){
            return null;
        }
        if(root.value==val){
            return root;
        }
        Node rootLeft=search(root.left,val);
        if(rootLeft!=null){
            return rootLeft;
        }
        Node rootRight=search(root.right,val);
        if(rootRight!=null){
            return rootRight;
        }
        return null;
    }
    public static boolean search1(Node root,int val){
        if(root==null){
            return false;
        }
        if(root.value==val){
            return true;
        }
        boolean left=search1(root.left,val);
        if(left==true){
            return true;
        }
        boolean right=search1(root.right,val);
        if(right==true){
            return true;
        }
        return false;
    }
    //判断两个树是否相等
    public static boolean isSameTree(Node p,Node q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        return p.value==q.value
                &&isSameTree(p.left,q.left)
                &&isSameTree(p.right,q.right);
    }
    //判断两个树是否镜像
    public static boolean isMirror(Node p,Node q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        return p.value==q.value
                &&isMirror(p.left,q.right)
                &&isMirror(p.right,q.left);
    }
    //判断一个树是否对称
    public static boolean isSymmetry(Node root){
        if(root==null){
            return true;
        }
        if(isMirror(root.left,root.right)){
            return true;
        }
        return false;
    }
    //判断一个树里面是否有特定的一个子树
    public static boolean isExit(Node root,Node t){
        if(root==null){
            return false;
        }
        if(root.value==t.value && isSameTree(root,t)){
            return true;
        }
        if(isExit(root.left,t)){
            return true;
        }
        return isExit(root.right,t);
    }
    public static void main(String[] args){
        Node root1=buileTree1();
        calLeftCount1(root1);
        System.out.println(count);
        System.out.println(calHeight(root1));
        System.out.println(calKCount(root1,1));
        Node node=search(root1,'O');
        if(node==null){
            System.out.println("Not find");
        }else {
            System.out.printf("%c", node.value);
        }
        System.out.println(search1(root1,'F'));
        Node root2=buildTree2();
        System.out.println(isSameTree(root1,root2));
        Node root3=buildTree3();
        System.out.println(isMirror(root1,root2));
        Node root4=buildTree4();
        System.out.println(isExit(root1,root2));
    }
}