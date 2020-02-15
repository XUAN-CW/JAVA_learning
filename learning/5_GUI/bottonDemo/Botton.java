package bottonDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botton {

    public static void main(String[] args) throws AWTException {
        JFrame jf = new JFrame("���Դ���");
        jf.setSize(500, 500);
        jf.setLocationRelativeTo(null);	//���ô�������λ�á�null,����û����Ե���������
        
        /**
         * 	setDefaultCloseOperation()�������û��ڴ˴����Ϸ��� "close" ʱĬ��ִ�еĲ�����
			DO_NOTHING_ON_CLOSE���� WindowConstants �ж��壩����ִ���κβ�����Ҫ���������ע��� WindowListener ����� windowClosing �����д���ò����� 
			HIDE_ON_CLOSE���� WindowConstants �ж��壩������������ע��� WindowListener ������Զ����ظô��塣 
			DISPOSE_ON_CLOSE���� WindowConstants �ж��壩������������ע�� WindowListener �Ķ�����Զ����ز��ͷŸô��塣 
			EXIT_ON_CLOSE���� JFrame �ж��壩��ʹ�� System exit �����˳�Ӧ�ó��򡣽���Ӧ�ó�����ʹ�á� 
         */
        jf.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        JPanel panel = new JPanel();		//�����������
        

        final JButton btn = new JButton("��ť1");
        final JButton btn2 = new JButton("��ť2");

        // ���ð�ť��Ĭ��ͼƬ
        //btn.setIcon(new ImageIcon("button_normal.png"));

        // ���ð�ť�����ʱ��ͼƬ
        //btn.setPressedIcon(new ImageIcon("button_press.png"));

        // ���Ʊ߿�
        btn.setBorderPainted(true);
        btn2.setBorderPainted(true);

        // ��Ӱ�ť����¼�������
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("��ť1�������");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("��ť2�������");
            }
        });

        panel.add(btn);		//��ť��ӵ����
        panel.add(btn2);	//��ť��ӵ����
        
        jf.setContentPane(panel);
        jf.setVisible(true);
        /**
         * ��ť���齨���齨���Ƿ���������ģ���Ҫ�����齨λ�ã���Ҫ���������֣�Ȼ����ݲ��ְѰ�ť�ŵ���Ҫ�ŵĵط���
			Ĭ�ϲ����� BorderLayout �������������Ų�����������ɢ
			�����Ĳ��ַ�ʽ���� FlowLayout���֣����������У�������ת����һ�м���
			����GridLayout �� n��m�е����񲼾�

			������Ҫ���Զ�λλ�ã�������null����
			��������һ������p
			p.setLayout(null);
			Button button=new Button();
			button.setBounds(int x,inty,width,height)
         */
        jf.setLayout(null);
        panel.setBackground(Color.black);	//������屳��ɫ
        btn.setForeground(Color.blue);		//���ð�ť������ɫ
        btn.setBackground(Color.GREEN);		//���ð�ť����ɫ
        
        btn.setBounds(100,100,100,100);
        
        btn2.setLocation(200, 58);
        
    }

}