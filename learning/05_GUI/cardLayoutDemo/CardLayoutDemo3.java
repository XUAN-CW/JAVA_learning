package cardLayoutDemo;
 
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
 
public class CardLayoutDemo3 extends JFrame {
	private JPanel cardPanel = null;
	private JPanel card1=null,card2=null; 
	private JPanel bottonPanel = null;
	private JButton b_2=null,b_3=null;
	
	private CardLayout card = null;
	
	
	public CardLayoutDemo3(){
		/** ¿¨Æ¬ */
		card1 = new JPanel();	card1.setBackground(Color.BLUE);
		card2 = new JPanel();	card2.setBackground(Color.GREEN);
		
		/** ¿¨Æ¬²¼¾Ö */
		card = new CardLayout(20,10);
		cardPanel = new JPanel(card);	
		cardPanel.add(card1,"p2");
		cardPanel.add(card2,"p3");
		
		/** °´Å¥ */
		bottonPanel = new JPanel();
		b_2 = new JButton("2");
		b_3 = new JButton("3");
		bottonPanel.add(b_2);
		bottonPanel.add(b_3);
		
	

	

		b_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(cardPanel,"p2");
			}
		});
		b_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(cardPanel,"p3");
			}
		});
		
//		JPanel jPanel=new JPanel();
//		jPanel.add(cardPanel);
//		jPanel.add(bottonPanel,BorderLayout.SOUTH);
		
		this.getContentPane().add(cardPanel);
		this.getContentPane().add(bottonPanel,BorderLayout.SOUTH);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new CardLayoutDemo3();
	}
 
}