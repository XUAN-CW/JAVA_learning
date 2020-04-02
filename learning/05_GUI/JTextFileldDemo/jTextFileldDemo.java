/**
 * Java Swing 文本框控件
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
		
		this.setTitle("文本框使用");
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
		
		JLabel label=new JLabel("姓名：");			//标签
		JTextField textField1=new JTextField();		//文本域
		textField1.setColumns(10);
		pane1.add(label);
		pane1.add(textField1);
        JLabel lab = new JLabel("我是一个标签",JLabel.CENTER);   // 实例化标签对象
        pane1.add(lab) ;    // 将组件件入到面板之中
		
        System.out.println(textField1.getText().toString());
        
        JTextField textField = new JTextField();//文本框
        String s=textField.getText().toString();//获得文本框的内容 
        
        
        
//		JLabel label2=new JLabel("年龄：");
//		JTextField textField2=new JTextField();
//		textField2.setColumns(10);
//		pane2.add(label2);
//		pane2.add(textField2);
//		
//		JLabel label3=new JLabel("住址：");
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