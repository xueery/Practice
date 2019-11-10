package Poke;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

public class Main {
    public static void swap(ArrayList<PokeCard> card, int i, int j){
        PokeCard tmp1=card.get(i);
        PokeCard tmp2=card.get(j);
        card.set(j,tmp1);
        card.set(i,tmp2);
    }
    public static void main(String[] args) {
        ArrayList<PokeCard> cards = new ArrayList<>();
        String[] colors = {"♥", "♠", "♦", "♣"};
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                PokeCard card = new PokeCard(j, colors[i]);
                cards.add(card);
            }
        }
        Random random = new Random(20190820);
        for (int i = 51; i > 0; i--) {
            int j = random.nextInt(i);
            swap(cards, j, i);
        }
        ArrayList<PokeCard> A = new ArrayList();
        ArrayList<PokeCard> B = new ArrayList();
        ArrayList<PokeCard> C = new ArrayList();
        System.out.println(cards.subList(52 - 15, 52));
        for (int i = 0; i < 15; i++) {
            PokeCard card = cards.remove(cards.size() - 1);
            switch (i % 3) {
                case 0:
                    A.add(card);
                    break;
                case 1:
                    B.add(card);
                    break;
                case 2:
                    C.add(card);
                    break;
            }
        }
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        PokeCard heartA = new PokeCard(12, "♥");
        if (A.contains(heartA)) {
            System.out.println("包含");

        } else {
            System.out.println("不包含");
        }
        for(PokeCard o:A){
            if(o.equals(heartA)){
                A.remove(heartA);
            }
        }
        System.out.println(A);
        Iterator<PokeCard> it1=A.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }
        ListIterator<PokeCard> it2=A.listIterator();
        System.out.println(it2.next());
        System.out.println(it2.next());
        System.out.println(it2.previous());
        System.out.println(it2.previous());
    }
}
