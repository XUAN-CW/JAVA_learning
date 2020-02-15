package FrameDemo;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo {

    public static void main(String[] args) {

        // 创建窗体对象
        Frame f = new Frame("QQ号码");
        f.setBounds(300, 300, 500, 400);
        //f.setLayout(new FlowLayout());//别忘了布局设置

        // 创建标签对象
        Label l = new Label("请输入QQ号码，非数字显示不出来");

        // 创建文本框对象
        TextField tf = new TextField(20);
        tf.setEditable(true);

        // 把组件添加到窗体中
        f.add(l);
        f.add(tf);

        // 设置窗体关闭监听事件
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        // 设置文本框的监听事件，对输入的数据进行监听
        // 由于是不让非数字的数据出现到文本框中
        // 所以监听对象是键盘：KeyListener键盘侦听器 KeyAdapter 键盘适配器
        tf.addKeyListener(new KeyAdapter() {
            // public void keyPressed(KeyEvent e)按下某个键时调用此方法。
            public void keyPressed(KeyEvent e) {// KeyEvent:键盘类
                // 首先得获取到键盘按下的字符
                // 然后进行判断是否是数字键，如果不是，则取消这次操作
                // public void consume()使用此事件，以便不会按照默认的方式由产生此事件的源代码来处理此事件
                char c = e.getKeyChar();
                if (!(c >= '0' && c <= '9')) {
                    e.consume();
                }
                if(c >= '0' && c <= '9') {
                	System.out.println(tf.getText()+c);
                }
            }
        });
        
        

        // 设置显示窗体
        f.setVisible(true);
        

    }
}