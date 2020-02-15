package bottonDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botton {

    public static void main(String[] args) throws AWTException {
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(500, 500);
        jf.setLocationRelativeTo(null);	//设置窗体的相对位置。null,代表没有相对的其他窗体
        
        /**
         * 	setDefaultCloseOperation()是设置用户在此窗体上发起 "close" 时默认执行的操作。
			DO_NOTHING_ON_CLOSE（在 WindowConstants 中定义）：不执行任何操作；要求程序在已注册的 WindowListener 对象的 windowClosing 方法中处理该操作。 
			HIDE_ON_CLOSE（在 WindowConstants 中定义）：调用任意已注册的 WindowListener 对象后自动隐藏该窗体。 
			DISPOSE_ON_CLOSE（在 WindowConstants 中定义）：调用任意已注册 WindowListener 的对象后自动隐藏并释放该窗体。 
			EXIT_ON_CLOSE（在 JFrame 中定义）：使用 System exit 方法退出应用程序。仅在应用程序中使用。 
         */
        jf.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        JPanel panel = new JPanel();		//创建面板容器
        

        final JButton btn = new JButton("按钮1");
        final JButton btn2 = new JButton("按钮2");

        // 设置按钮的默认图片
        //btn.setIcon(new ImageIcon("button_normal.png"));

        // 设置按钮被点击时的图片
        //btn.setPressedIcon(new ImageIcon("button_press.png"));

        // 绘制边框
        btn.setBorderPainted(true);
        btn2.setBorderPainted(true);

        // 添加按钮点击事件监听器
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮1被点击了");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮2被点击了");
            }
        });

        panel.add(btn);		//按钮添加到面板
        panel.add(btn2);	//按钮添加到面板
        
        jf.setContentPane(panel);
        jf.setVisible(true);
        /**
         * 按钮是组建，组建都是放在容器里的，你要设置组建位置，先要对容器布局，然后根据布局把按钮放到想要放的地方，
			默认布局是 BorderLayout 按东南西北中排布，向四周扩散
			常见的布局方式还有 FlowLayout布局：从左到右排列，排满后转到下一行继续
			还有GridLayout 按 n行m列的网格布局

			但你若要绝对定位位置，可以用null布局
			比如你有一个容器p
			p.setLayout(null);
			Button button=new Button();
			button.setBounds(int x,inty,width,height)
         */
        jf.setLayout(null);
        panel.setBackground(Color.black);	//设置面板背景色
        btn.setForeground(Color.blue);		//设置按钮字体颜色
        btn.setBackground(Color.GREEN);		//设置按钮背景色
        
        btn.setBounds(100,100,100,100);
        
        btn2.setLocation(200, 58);
        
    }

}