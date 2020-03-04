package JavaEveryDayPractice33;

/**
 * @author:wangxue
 * @date:2020/3/2 20:07
 */
public class Main {
    public static int countNumberOf2s(int n) {
        if(n<2){
            return 0;
        }
        int result=n%10>1 ? 1:0;
        int index=1,count=1;
        int temp=0,m=n;
        while((n/=10)!=0){
            temp=n%10;
            result+=temp*index*count;
            index*=10;
            count++;
            if(temp>2){
                result+=index;
            }
            if(temp==2){
                result=result+1+m%index;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countNumberOf2s(100));
    }
}