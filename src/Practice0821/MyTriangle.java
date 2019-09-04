package Practice0821;

public class MyTriangle {
    //三角形最大周长
    public static int mostTrianglePer(int[] array){
        int mostPer=0;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                for(int k=j+1;k<array.length;k++){
                    if(theorem(array[i],array[j],array[k])){
                        int per=array[i]+array[j]+array[k];
                        if(mostPer<per)
                        mostPer=per;
                    }
                }
            }
        }
        return mostPer;
    }
    //判断是否符合三角形构成定理
    public static boolean theorem(int i,int j,int k){
        if(i+j>k && j+k>i && i+k>j){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,5};
        System.out.println(mostTrianglePer(array));
    }
}
