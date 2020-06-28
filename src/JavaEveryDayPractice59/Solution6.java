package JavaEveryDayPractice59;

/**
 * @author:wangxue
 * @date:2020/6/19 9:28
 */
public class Solution6 {
    // 孩子们的游戏
    // 圆圈中最后剩下的数
    public int LastRemaining_Solution(int n, int m){
        if(n<1 || m<1) return -1;
        int[] array=new int[n];
        int i=-1,step=-1,count=n;
        while(count>0){//跳出循环时将最后一个元素也设置为了-1
            i++;//指向上一个被删除对象的下一个元素
            if(i>=n) i=0;// 模拟环
            if(array[i]==-1)continue;//跳过被删除的对象
            step++;// 记录走过的
            if(step==m-1){//找到待删除的对象
                array[i]=-1;
                count--;
                step=-1;
            }
        }
        return i;
    }
}
