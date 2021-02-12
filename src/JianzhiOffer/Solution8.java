package JianzhiOffer;

/**
 * @author:wangxue
 * @date:2021/2/6 11:56
 */
// 跳台阶
public class Solution8 {
    public int JumpFloor(int target) {
        if(target<3)return target;
        int n1=1;
        int n2=2;
        int n=0;
        for(int i=3;i<=target;i++){
            n=n1+n2;
            n1=n2;
            n2=n;
        }
        return n;
    }
}

