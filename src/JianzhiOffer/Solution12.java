package JianzhiOffer;

/**
 * @author:wangxue
 * @date:2021/2/15 20:22
 */
// 数值的整数次方
public class Solution12 {
    public double Power(double base, int exponent) {
        double sum=1;
        if(exponent>0) {
            for (int i = 0; i < exponent; i++) {
                sum = sum * base;
            }
        }else if(exponent<0){
            for(int i=0;i<-exponent;i++){
                sum=sum*base;
            }
            sum=1/sum;
        }else{
            sum=1;
        }
        return sum;
    }
}
