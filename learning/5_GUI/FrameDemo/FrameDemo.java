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

        // �����������
        Frame f = new Frame("QQ����");
        f.setBounds(300, 300, 500, 400);
        //f.setLayout(new FlowLayout());//�����˲�������

        // ������ǩ����
        Label l = new Label("������QQ���룬��������ʾ������");

        // �����ı������
        TextField tf = new TextField(20);
        tf.setEditable(true);

        // �������ӵ�������
        f.add(l);
        f.add(tf);

        // ���ô���رռ����¼�
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        // �����ı���ļ����¼�������������ݽ��м���
        // �����ǲ��÷����ֵ����ݳ��ֵ��ı�����
        // ���Լ��������Ǽ��̣�KeyListener���������� KeyAdapter ����������
        tf.addKeyListener(new KeyAdapter() {
            // public void keyPressed(KeyEvent e)����ĳ����ʱ���ô˷�����
            public void keyPressed(KeyEvent e) {// KeyEvent:������
                // ���ȵû�ȡ�����̰��µ��ַ�
                // Ȼ������ж��Ƿ������ּ���������ǣ���ȡ����β���
                // public void consume()ʹ�ô��¼����Ա㲻�ᰴ��Ĭ�ϵķ�ʽ�ɲ������¼���Դ������������¼�
                char c = e.getKeyChar();
                if (!(c >= '0' && c <= '9')) {
                    e.consume();
                }
                if(c >= '0' && c <= '9') {
                	System.out.println(tf.getText()+c);
                }
            }
        });
        
        

        // ������ʾ����
        f.setVisible(true);
        

    }
}