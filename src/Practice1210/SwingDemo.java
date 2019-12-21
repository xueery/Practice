package Practice1210;

import javax.swing.*;
import java.awt.*;

/**
 * @author:wangxue
 * @date:2019/12/14 11:00
 */
public class SwingDemo {
    public static void main(String[] args) {
        JFrame frame=new JFrame("用户注册");
        frame.setLayout(null);
        frame.setSize(300,300);
        frame.setLocation(500,200);
        JLabel userLa=new JLabel("用户名");
        JLabel passLa=new JLabel("密码");
        JLabel qqLa=new JLabel("QQ号");
        JLabel emailLa=new JLabel("电子邮件");
        JLabel sexLa=new JLabel("性别");
        JTextField userText=new JTextField(20);
        JPasswordField passwordField=new JPasswordField(20);
        JTextField qqText=new JTextField(20);
        JTextField emailText=new JTextField(20);
        JTextField sexText=new JTextField(20);
        userLa.setSize(80,30);
        userLa.setLocation(40,40);
        passLa.setSize(80,30);
        passLa.setLocation(40,80);
        qqLa.setSize(80,30);
        qqLa.setLocation(40,120);
        emailLa.setSize(80,30);
        emailLa.setLocation(40,160);
        sexLa.setSize(80,30);
        sexLa.setLocation(40,200);
        userText.setSize(160,30);
        userText.setLocation(100,40);
        passwordField.setSize(160,30);
        passwordField.setLocation(100,80);
        qqText.setSize(160,30);
        qqText.setLocation(100,120);
        emailText.setSize(160,30);
        emailText.setLocation(100,160);
        sexText.setSize(160,30);
        sexText.setLocation(100,200);
        frame.add(userLa);
        frame.add(passLa);
        frame.add(qqLa);
        frame.add(emailLa);
        frame.add(sexLa);
        frame.add(userText);
        frame.add(passwordField);
        frame.add(qqText);
        frame.add(emailText);
        frame.add(sexText);
        frame.setVisible(true);
    }
}
