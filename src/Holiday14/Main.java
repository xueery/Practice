package Holiday14;

import java.util.*;

/**
 * @author:wangxue
 * @date:2020/2/3 10:41
 */
public class Main {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(i==size-1){
                    list.add(node.val);
                }
            }
        }
        return list;
    }

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:deck){
            int count=map.getOrDefault(i,0);
            map.put(i,++count);
        }
        for(int i=0;i<deck.length-1;i++){
            if(map.get(deck[i])<2){
                return false;
            }
            if(map.get(deck[i+1])!=map.get(deck[i])){
                return false;
            }
        }
        return true;
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftL=maxDepth(root.left);
        int rightL=maxDepth(root.right);
        return Math.max(leftL,rightL)+1;
    }
    public static void main(String[] args) {
    }
}