package Practice1012;

import java.util.Calendar;

/**
 * @author:wangxue
 * @date:2019/10/12 8:10
 */
public class CalendarDemo {
    public static void main(String[] args) {
        //Calendar用于完成日期和时间字段的操作
        Calendar calendar1=Calendar.getInstance();
        int year=calendar1.get(Calendar.YEAR);
        int month=calendar1.get(Calendar.MONTH)+1;
        int date=calendar1.get(Calendar.DATE);
        int minute=calendar1.get(Calendar.MINUTE);
        System.out.println("当前时间为："+year+"年"+month+"月"+date+"日"+minute+"分");
        Calendar calendar2=Calendar.getInstance();
        //设置指定日期
        calendar2.set(2019,10,12);
        //为指定日期增加时间
        calendar2.add(Calendar.DATE,100);
        System.out.println("100天之后为："+calendar2.get(Calendar.YEAR)+"年"+
                calendar2.get(Calendar.MONTH)+"月"+calendar2.get(Calendar.DATE)+"日");
        Calendar calendar3=Calendar.getInstance();
        //日历的容错模式lenient模式，默认使用容错模式
        calendar3.set(Calendar.MONTH,13);
        System.out.println(calendar3.getTime());
    }
}
