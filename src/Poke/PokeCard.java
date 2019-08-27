package Poke;

public class PokeCard {
    int val;
    String color;
    PokeCard(int val,String color){
        this.val=val;
        this.color=color;
    }

    @Override
    public String toString() {
        return String.format("[%d],[%s]",val,color);
    }
    @Override
    public boolean equals(Object obj) {
        //先判断是否为空
        if(obj==null){
            return false;
        }
        //判断是否是该类型
        if(!(obj instanceof PokeCard)){
            return false;
        }
        //再判断本身
        PokeCard other=(PokeCard) obj;
        return this.val==other.val &&
                //String是引用类型，是不能直接进行比较，需要用equals方法比较
                this.color.equals(other.color);
    }

}
