package Practice0827;

import java.util.Arrays;
import java.util.Random;

/**
 * @author:wangxue
 * @date:2019/8/27 12:04
 */
public class TopK {
    public static int[] fineTopK(int[] wulin,int k){
        int[] heaps=new int[k];
        for(int i=0;i<k;i++){
            heaps[i]=wulin[i];
        }
        Heaps.creatSmallHeap(heaps,heaps.length);
        for(int i=k;i<wulin.length;i++){
            if(wulin[i]>heaps[0]){
                heaps[0]=wulin[i];
                Heaps.heapifyMin(heaps,k,0);
            }
        }
        return heaps;
    }
    public static void main(String[] args) {
        int[] wulin=new int[30];
        Random random=new Random(19990703);
        for(int i=0;i<wulin.length;i++){
            wulin[i]=random.nextInt(1000);
        }
        int[] top=fineTopK(wulin,10);
        System.out.println(Arrays.toString(top));
        Arrays.sort(wulin);
        System.out.println(Arrays.toString(Arrays.copyOfRange(wulin,wulin.length-20,wulin.length)));
    }
}
