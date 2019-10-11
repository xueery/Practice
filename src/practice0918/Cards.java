package practice0918;

/**
 * @author:wangxue
 * @date:2019/9/18 7:57
 */
public class Cards{
     public int value;
     public String color;
     public Cards(int value,String color){
         this.value=value;
         this.color=color;
     }

    @Override
    public int hashCode() {
        return value+color.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
         if(obj==this){
             return true;
         }
         if(obj==null){
             return false;
         }
         if(obj.getClass()!=this.getClass()){
             return false;
         }
         Cards c=(Cards) obj;
         return this.value==c.value && this.color.equals(c.color);
    }
}
