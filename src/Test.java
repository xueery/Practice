public class Test {
    public static int searchMostNum(int[] array){
        int halflength=array.length/2;
        for(int i=0;i<array.length;i++){
            int count=0;
            for(int j=0;j<array.length;j++){
                if(array[i]==array[j]){
                    count++;
                }
            }
            if(count>halflength){
                return array[i];
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] array={1,2,2,2,2,5,6,2,2,2,0};
        int ret=searchMostNum(array);
        if(ret!=-1) {
            System.out.println(ret);
        }else{
            System.out.println("Not Find");
        }
    }
}
