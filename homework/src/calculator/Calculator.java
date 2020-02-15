package calculator;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Calculator{
	private JFrame myFrame;
	
	public Calculator() {
		super();
		setFrame();
		addModule();
		myFrame.setVisible(true);
	}

	private void setFrame() {
		myFrame = new JFrame("���׼�����");
//		myFrame.setTitle();
		myFrame.setBounds(100, 100, 200, 200);
		myFrame.setLocationRelativeTo(null);	//������г���
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		myFrame.setLayout(null);		//����Ϊnull����
		myFrame.setResizable(false);	//�������� 
	}
	
	private void addModule() {
		/** ��ǩ */
		JLabel operandLabel1 = new JLabel("������1");
		operandLabel1.setLocation(50, 50);
		JLabel operandLabel2 = new JLabel("������2");
		JLabel outcomeLabel =new JLabel("���");
		/** �ı��� */
		JTextField operandtField1=new JTextField();
		JTextField operandtField2=new JTextField();
		JTextField outcomeField=new JTextField();
		operandtField1.setColumns(10);
		operandtField2.setColumns(10);
		outcomeField.setColumns(10);
		/** ��ť */
		JButton addButton=new JButton("��");
		JButton subtractButton=new JButton("��");
		/** ������������������� */
		JPanel panel = new JPanel();		
        panel.add(operandLabel1);
        panel.add(operandtField1);
        panel.add(operandLabel2);
        panel.add(operandtField2);
		panel.add(outcomeLabel);
		panel.add(outcomeField);
		panel.add(addButton);
		panel.add(subtractButton);
        
		/** null���� */
        myFrame.setContentPane(panel);
        myFrame.setVisible(true);
        myFrame.setLayout(null);
        
        /** λ������ */
        operandLabel1.setLocation(0, 10);
        operandtField1.setLocation(50, 10);
        operandLabel2.setLocation(0, 50);
        operandtField2.setLocation(50, 50);
        outcomeLabel.setLocation(0, 90);
        outcomeField.setLocation(50, 90);
        addButton.setLocation(50,130);
        subtractButton.setLocation(100, 130);
        
        /** �¼����� */
     // ��Ӱ�ť����¼�������
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            try {
				Integer o1=new Integer(operandtField1.getText());
            	Integer o2=new Integer(operandtField2.getText());
            	int outcome=o1.intValue()+o2.intValue();
            	outcomeField.setText(String.valueOf(outcome));
            } catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"��ʾ","���벻�Ϸ�", JOptionPane.INFORMATION_MESSAGE);
            	}	
            }
        });
        
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//            	try {
//    				Integer o1=new Integer(operandtField1.getText());
//                	Integer o2=new Integer(operandtField2.getText());
//                	int outcome=o1.intValue()-o2.intValue();
//                	outcomeField.setText(String.valueOf(outcome));
//                } catch (Exception e2) {
//    				JOptionPane.showMessageDialog(null,"��ʾ","���벻�Ϸ�", JOptionPane.INFORMATION_MESSAGE);
//                	}	
            
                }
        });
	}
	
	
	public JFrame getMyFrame() {
		return myFrame;
	}

	public void setMyFrame(JFrame myFrame) {
		this.myFrame = myFrame;
	}
}
