/**
 * Java Swing �ı���ؼ�
 * @author gao 
 */
package JTextFileldDemo;
 
import java.awt.GridLayout;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
 
public class jTextFileldDemo extends JFrame{
	public jTextFileldDemo(){
		
		this.setTitle("�ı���ʹ��");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 250, 200);
		JPanel contentPane=new JPanel();
		//contentPane.setBorder(new EmptyBorder(5,5,5,5));
		this.setContentPane(contentPane);
		//contentPane.setLayout(new GridLayout(3,1,5,5));
		
		JPanel pane1=new JPanel();
		contentPane.add(pane1);
//		JPanel pane2=new JPanel();
//		contentPane.add(pane2);
//		JPanel pane3=new JPanel();
//		contentPane.add(pane3);
		
		JLabel label=new JLabel("������");			//��ǩ
		JTextField textField1=new JTextField();		//�ı���
		textField1.setColumns(10);
		pane1.add(label);
		pane1.add(textField1);
        JLabel lab = new JLabel("����һ����ǩ",JLabel.CENTER);   // ʵ������ǩ����
        pane1.add(lab) ;    // ��������뵽���֮��
		
        System.out.println(textField1.getText().toString());
        
        JTextField textField = new JTextField();//�ı���
        String s=textField.getText().toString();//����ı�������� 
        
        
        
//		JLabel label2=new JLabel("���䣺");
//		JTextField textField2=new JTextField();
//		textField2.setColumns(10);
//		pane2.add(label2);
//		pane2.add(textField2);
//		
//		JLabel label3=new JLabel("סַ��");
//		JTextField textField3=new JTextField();
//		textField3.setColumns(10);
//		pane3.add(label3);
//		pane3.add(textField3);
		
		this.setVisible(true);
	}
    public static void main(String[]args){
    	jTextFileldDemo example=new jTextFileldDemo();
    }
}