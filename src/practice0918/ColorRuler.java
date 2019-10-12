package practice0918;

/**
 * @author:wangxue
 * @date:2019/9/18 8:45
 */
public class ColorRuler implements Comparable<ColorRuler>{
    String coloruler;
    public ColorRuler(String coloruler){
        this.coloruler=coloruler;
    }
    @Override
    public int compareTo(ColorRuler o) {
        return coloruler.hashCode()-o.coloruler.hashCode();
    }
}
