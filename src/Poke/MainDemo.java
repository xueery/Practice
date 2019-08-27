package Poke;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MainDemo {
    public static void swap(ArrayList<PokeCard> cards, int i, int j){
        PokeCard tmp1=cards.get(i);
        PokeCard tmp2=cards.get(j);
        cards.set(i,tmp2);
        cards.set(j,tmp1);
    }
    public static void main(String[] args) {
        //创建扑克牌
        ArrayList<PokeCard> cards=new ArrayList<>();
        String[] color={"♥","♠","♣","♦"};
        for(int i=0;i<4;i++){
            for(int j=1;j<=13;j++){
                PokeCard card= new PokeCard(j,color[i]);
                cards.add(card);
            }
        }
        //洗牌
        Random random=new Random(20180820);
        for(int i=51;i>0;i--){
            int j=random.nextInt(i);
            swap(cards,i,j);
        }
        System.out.println(cards);
        //给三个人发牌
        ArrayList<PokeCard> A=new ArrayList<>();
        ArrayList<PokeCard> B=new ArrayList<>();
        ArrayList<PokeCard> C=new ArrayList<>();
        System.out.println(cards.subList(52-15,52));
        for(int i=0;i<15;i++){
            PokeCard card=cards.remove(cards.size()-1);
            switch(i%3){
                case 0:
                    A.add(card);
                    break;
                case 1:
                    B.add(card);
                    break;
                case 2:
                    C.add(card);
            }
        }
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        //查看是否某人手中有那个牌
        PokeCard heartA=new PokeCard(11,"♦");
        Iterator<PokeCard> it=A.iterator();
        while(it.hasNext()){
            PokeCard o=it.next();
            if(o.equals(heartA)){
                it.remove();
            }
        }
        //这个不能用来删除
        /*for(PokeCard a:A){
            if(a.equals(heartA)){
                A.remove(a);
            }
        }
        for(PokeCard a:A){
            if(a.equals(heartA)){
                A.remove(heartA);
            }
        }*/
        if(A.contains(heartA)){
            A.remove(heartA);
        }
        System.out.println(A);
    }
}
