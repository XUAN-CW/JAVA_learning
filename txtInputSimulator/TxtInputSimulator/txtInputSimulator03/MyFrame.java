package txtInputSimulator03;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import txtInputSimulator04.MycomboBox;
import txtInputSimulator04.TxtJScrollPane;



public class MyFrame extends JFrame{
	JMenuBar bar=null;
	JMenuItem instruction=null;
	JMenuItem startInput=null;
	
	MycomboBox<String> txts;
	TxtJScrollPane txtArea=null;
	
	
	public MyFrame() {
		super();
		initMyFrame();
		initBar();
		initStartInputItem();
		initInstructionItem();
		initTxtArea();
		initTxts();
	}
	
	private void initMyFrame() {
		setTitle("��������ģ����3.0");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);	//������г���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
//		setResizable(false);	//�������� 
	}

	private void initBar() {
		this.bar = new JMenuBar();	// JMenuBar�ǷŲ˵���ĸ��,�ֳ�Ϊ�˵���
		setJMenuBar(this.bar);
	}

	private void initInstructionItem() {
//		ʹ��˵��
		this.instruction = new JMenuItem("ʹ��˵��");
		this.instruction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"��ģ�������ַ����£�\n"
						+ "1234567890`~!@#$%^&*()_+[]\\;\',./{}|:\"<>?\n"
						+ "abcdefghijklnmopqrstuvwxyzABCDEFGHIJKLNMOPQRSTUVWXYZ\n"
						+ "�ո񡢻س���tab\n"
						+ "�������ַ��������ַ�����ģ������",
						"ʹ��˵��", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		this.bar.add(this.instruction);
	}

	private void initStartInputItem() {
		this.startInput = new JMenuItem("����˴�1�������");
		this.startInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtArea.input();
			}
		});
		this.bar.add(startInput);
	}

	private void initTxts() {
		this.txts = new MycomboBox<String>();
		this.bar.add(txts);
		this.txts.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// ֻ����ѡ�е�״̬
              if (e.getStateChange() == ItemEvent.SELECTED) {
            	  txts.setItemCorrespondingString(txtArea.getTxtArea().getText(), txts.getCurrentSelected());
            	  txtArea.getTxtArea().setText(txts.getItemListCorrespondingStringList()[txts.getSelectedIndex()]);
            	  txts.setCurrentSelected(txts.getSelectedIndex());
              }
			}
		});
	}

	private void initTxtArea() {
		this.txtArea=new TxtJScrollPane();
		this.getContentPane().add(txtArea);
	}
	

	public JMenuBar getBar() {
		return bar;
	}

	public void setBar(JMenuBar bar) {
		this.bar = bar;
	}

	public JMenuItem getInstruction() {
		return instruction;
	}

	public void setInstruction(JMenuItem instruction) {
		this.instruction = instruction;
	}

	public JMenuItem getStartInput() {
		return startInput;
	}

	public void setStartInput(JMenuItem startInput) {
		this.startInput = startInput;
	}

	public MycomboBox<String> getTxts() {
		return txts;
	}

	public void setTxts(MycomboBox<String> txts) {
		this.txts = txts;
	}

	public TxtJScrollPane getTxtArea() {
		return txtArea;
	}

	public void setTxtArea(TxtJScrollPane txtArea) {
		this.txtArea = txtArea;
	}

	
	
	
	
	
	
}
