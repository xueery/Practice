package Practice1002;

/**
 * @author:wangxue
 * @date:2019/10/4 12:59
 */
public class Books implements Comparable<Books>{
    int price;
    String name;
    Books(int price,String name){
        this.price=price;
        this.name=name;
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(this==null||obj==null){
            return false;
        }
        if(this.getClass()!=obj.getClass()){
            return false;
        }
        Books book=(Books)obj;
        return price==book.price && name.equals(book.name);
    }

    @Override
    public int compareTo(Books o) {
        return price-o.price;
    }
}
