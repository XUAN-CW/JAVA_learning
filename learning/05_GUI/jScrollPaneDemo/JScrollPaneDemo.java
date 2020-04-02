package jScrollPaneDemo;
/**
 * java swing ֮JScrollPane���
 * �����ý���ʱ�����ܻ�������һ����С��������������ʾһ���ϴ󲿷ֵ����ݣ���ʱ����ʹ��
 * JScrollPane��壬JscrollPane����Ǵ�����������壬Ҳ��һ�����������ǳ����ڲ��õ���
 * �ؼ������Ҳ�����ʹ�ò��ֹ������������Ҫ��JScrollPane����з��ö���ؼ�����Ҫ�����
 * �ؼ����õ�JPanel ����ϣ�Ȼ��JPanel�����Ϊһ������ؼ���ӵ�JScrollPane�ؼ��ϡ�
 * 
 * @author ago
 */

 
import java.awt.BorderLayout;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
 
public class JScrollPaneDemo extends JFrame{
    private JPanel contentPane; 
    private JScrollPane scrollPane;
    private JTextArea textArea;
	public JScrollPaneDemo(){
    	 contentPane=new JPanel();
    	 contentPane.setBorder(new EmptyBorder(5,5,5,5));
    	 contentPane.setLayout(new BorderLayout(0,0));
    	 this.setContentPane(contentPane);
    	 
    	 
    	 scrollPane=new JScrollPane();
    	 contentPane.add(scrollPane,BorderLayout.CENTER);
    	 textArea=new JTextArea();
//    	 scrollPane.add(textArea); 
    	 scrollPane.setViewportView(textArea);
    	 
    	 
    	 
    	 
    	 
    	 
    	 this.setTitle("�������ʹ��");
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 this.setBounds(100, 100, 250, 200);
    	 this.setVisible(true);
     }
	public static void main(String []args){
		JScrollPaneDemo example=new JScrollPaneDemo(); 
	}
}