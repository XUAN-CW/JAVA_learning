import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author XUAN
 * @date 2020/9/8 - 20:12
 * @references
 * @purpose 用于解决 VirtualBox  无法复制粘贴的问题。
 *          曲线救国，先把要输入的放到文本区域内，再使用此模拟器输入
 */
public class Window extends JFrame {
    public  Window(){
        super();
        setWindow();
        addComponent();
        setVisible(true);
    }

    private void setWindow(){
        setTitle("键盘输入模拟器精简版");
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);	//窗体居中出现
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);	//可缩放
    }

    private void addComponent(){
        //文本区域
        JTextArea txtArea = new JTextArea(); 	// 创建一个文本区域
        txtArea.setLineWrap(true);				// 设置自动换行
        JScrollPane txtSPanel=new JScrollPane();//可滑动
        txtSPanel.setViewportView(txtArea);     //设置文本区域

        // 菜单栏及其 Item
        JMenuBar bar = new JMenuBar();	// JMenuBar是放菜单的母版,又称为菜单栏
        JMenuItem startInput = new JMenuItem("点击此处2秒后输入文本框中字符");
        startInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Thread.sleep(2000);
                    new Input().StartInput(txtArea.getText(),25);
                } catch (AWTException | InterruptedException awtException) {
                    awtException.printStackTrace();
                }
            }
        });
        bar.add(startInput);
        setJMenuBar(bar);		        // 将菜单栏对象放在窗体的菜单栏中
        this.getContentPane().add(txtSPanel);
    }

    public static void main(String[] args) {
        new Window();
    }
}
