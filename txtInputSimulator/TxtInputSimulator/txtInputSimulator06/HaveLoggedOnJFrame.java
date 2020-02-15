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

 
public class HaveLoggedOnJFrame extends JFrame{
	JButton logOutButton;
	public HaveLoggedOnJFrame(String account){
		
		this.setTitle("µÇÂ¼");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 250, 180);
		setLocationRelativeTo(null); 
		setLayout(null);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
		JPanel pane1=new JPanel();
		getContentPane().add(pane1);
		
		
		JLabel accountLabel=new JLabel("["+account+"]"+"ÒÑµÇÂ¼");			//±êÇ©
		accountLabel.setBounds(50,20,120,25);
		getContentPane().add(accountLabel);
        
        
		
		logOutButton=new JButton("ÍË³öµÇÂ¼");
		logOutButton.setBounds(60,100,120,25);
		getContentPane().add(logOutButton);
		
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
	
	
//    public static void main(String[]args){
//    	HaveLoggedOnJFrame example=new HaveLoggedOnJFrame("1111");
//    }
}