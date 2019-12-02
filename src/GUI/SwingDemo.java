package GUI;

import javax.swing.*;

/**
 * @author:wangxue
 * @date:2019/10/21 20:50
 */
public class SwingDemo {
    //Swing组件中最常见的容器JFrame（独立存在）支持通用窗口的所有基本功能，例如窗口最小化、设置窗口大小
    private static void createAndShowGUIJFrame(){
        //创建并设置JFrame容器窗口名字
        JFrame frame=new JFrame("JFRameTest");
        //设置关闭窗口时的默认操作
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口尺寸
        frame.setSize(250,150);
        //展示JFrame容器窗口
        frame.setVisible(true);
    }
    //JDialog容器通常来表示对话框窗口，对话框有两种：模态对话框、非模态对话框
    public static void createAndShowGUIJDialog(){
        JFrame frame=new JFrame("JFrameTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,150);
        frame.setVisible(true);
        //在JFrame容器窗口基础上创建并设置JDialog容器窗口
        JDialog dialog=new JDialog(frame,"JDialog对话框",true);
        dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        dialog.setSize(200,100);
        dialog.setVisible(true);
    }
    public static void main(String[] args) {
        //使用SwingUtilities工具类调用此方法，且该方法需要传入一个接口作为参数。
        //SwingUtilities.invokeLater(SwingDemo::createAndShowGUIJFrame);
        //传入的参数表示实现了改接口的方法
        //也可以写成下面的这行Lambda表达式
        //SwingUtilities.invokeLater(()->SwingDemo.createAndShowGUIJDialog());
        SwingUtilities.invokeLater(SwingDemo::createAndShowGUIJDialog);
    }
}