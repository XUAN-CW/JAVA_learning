/**
 * Java Swing ÎÄ±¾¿ò¿Ø¼þ
 * @author gao 
 */
package txtInputSimulator06;
 
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

//import sun.reflect.generics.tree.BottomSignature;
 
public class LoggingJFrame extends JFrame{
	JButton loggingButton;
	JButton registerButton;
	JTextField accountTextField;
	JTextField passwordTextField;
	public LoggingJFrame(){
		
		this.setTitle("µÇÂ¼");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 250, 180);
		setLayout(null);
		setLocationRelativeTo(null); 
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
		JPanel pane1=new JPanel();
		getContentPane().add(pane1);
		
		
		JLabel accountLabel=new JLabel("ÕËºÅ£º");			//±êÇ©
		accountTextField=new JTextField();		//ÎÄ±¾Óò
		accountTextField.setColumns(10);
		accountLabel.setBounds(30,20,120,25);
		accountTextField.setBounds(70,20,120,25);
		getContentPane().add(accountLabel);
		getContentPane().add(accountTextField);
        
        
		JLabel passwordLabel=new JLabel("ÃÜÂë£º");
		passwordTextField=new JTextField();
		passwordTextField.setColumns(10);
		passwordLabel.setBounds(30,60,120,25);
		passwordTextField.setBounds(70,60,120,25);
		getContentPane().add(passwordLabel);
		getContentPane().add(passwordTextField);
		
		loggingButton=new JButton("µÇÂ¼");
		loggingButton.setBounds(50,100,60,25);
//		button.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println(accountTextField.getText()+passwordTextField.getText());
//			}
//		});
		getContentPane().add(loggingButton);
		
		registerButton=new JButton("×¢²á");
		registerButton.setBounds(130,100,60,25);
		getContentPane().add(registerButton);
		
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
//				this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.setVisible(true);
	}
	
	
    public static void main(String[]args){
    	LoggingJFrame example=new LoggingJFrame();
    }
}