

package windowButtonSwitch;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WindowButtonSwitch implements ActionListener{
    JFrame f1,f2;
    JPanel p1,p2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    JTextField t1,t2;
    JPasswordField s1,s2;
    
    WindowButtonSwitch() {
        f1 = new JFrame("��½");
        p1 = new JPanel();
        b1 = new JButton("ע���˺�");
        l1 = new JLabel("�˺ţ�");
        t1 = new JTextField(18);
        l2 = new JLabel("���룺");
        s1 = new JPasswordField(18);
        b3 = new JButton("��½");
        f1.add(p1);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(s1);
        p1.add(b3);
        p1.add(b1);
        f1.setVisible(true);
        f1.setSize(280,150);
        b1.addActionListener(this);
   
    }
    

    public static void main(String[] args) {
        new WindowButtonSwitch();
    }

    public void actionPerformed(ActionEvent e) {
        f2 = new JFrame("ע��");
        p2 = new JPanel();
        b2 = new JButton("ȷ��");
        l3 = new JLabel("�˺ţ�");
        t2 = new JTextField(18);
        l4 = new JLabel("���룺");
        s2 = new JPasswordField(18);
        f2.add(p2);
        p2.add(l3);
        p2.add(t2);
        p2.add(l4);
        p2.add(s2);
        p2.add(b2);
        f2.setVisible(true);
        f1.setVisible(false);
        f2.setSize(280,150);
    }

}