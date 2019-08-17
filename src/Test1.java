public class Test1 {
    public static void reverseArray(char[] array,int start,int end){
        int i=start;
        int j=end;
        for(;i<j;i++,j--){
            char tmp=array[i];
            array[i]=array[j];
            array[j]=tmp;
        }
    }
    public static void main(String[] args) {
        char[] array={'I',' ','a','m',' ','a',' ','g','i','r','l'};
        int start=0;
        int end=start;
        int i=start;
        for(;i<array.length;i++){
            if(array[i]==' '){
                end=i-1;
                reverseArray(array,start,end);
                start=i+1;
            }
        }
        reverseArray(array,start,i-1);
        reverseArray(array,0,i-1);
        for(i=0;i<array.length;i++){
            System.out.printf("%c",array[i]);
        }
        System.out.println();
    }
}
