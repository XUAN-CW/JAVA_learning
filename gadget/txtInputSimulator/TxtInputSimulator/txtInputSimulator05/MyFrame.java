package txtInputSimulator05;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import txtInputSimulator05_2.MycomboBox;
import txtInputSimulator05_2.Myrobot;
import txtInputSimulator05_2.SaveAndRead;
import txtInputSimulator05_2.TxtJScrollPane;



public class MyFrame extends JFrame{
	JMenuBar bar=null;
	JMenuItem instruction=null;
	JMenuItem startInput=null;
	JMenuItem stopInputItem=null;
	
	MycomboBox<String> txts;
	TxtJScrollPane txtArea=null;
	SaveAndRead saveAndRead=null;
	
	Myrobot myrobot=null;
	
	public MyFrame() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initMyFrame();
		initBar();
		initMyRobot();
		initStartInputItem();
		initInstructionItem();
		initTxtArea();
		initTxts();
		initSaveAndRead();
		readWhenOpen();
	}
	
	private void initMyFrame() {
		setTitle("键盘输入模拟器5.2");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);	//窗体居中出现
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
//		setResizable(false);	//不可缩放 
	}

	private void initBar() {
		this.bar = new JMenuBar();	// JMenuBar是放菜单的母版,又称为菜单栏
		setJMenuBar(this.bar);
	}

	private void initInstructionItem() {
//		使用说明
		this.instruction = new JMenuItem("使用说明");
		this.instruction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"可模拟输入字符如下：\n"
						+ "1234567890`~!@#$%^&*()_+[]\\;\',./{}|:\"<>?\n"
						+ "abcdefghijklnmopqrstuvwxyzABCDEFGHIJKLNMOPQRSTUVWXYZ\n"
						+ "空格、回车、tab\n"
						+ "除以上字符，其他字符不会模拟输入",
						"使用说明", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		this.bar.add(this.instruction);
	}

	public void initMyRobot() {
			try {
			myrobot=new Myrobot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
	}
	
	private void initStartInputItem() {	
		this.startInput = new JMenuItem("点击此处1秒后输入");
		this.startInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myrobot.input(txtArea.getTxtArea().getText());
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
				// 只处理选中的状态
              if (e.getStateChange() == ItemEvent.SELECTED) {
            	  txts.setItemCorrespondingString(txtArea.getTxtArea().getText(), txts.getCurrentSelected());
            	  txtArea.getTxtArea().setText(txts.getItemListCorrespondingStringList()[txts.getSelectedIndex()]);
            	  txts.setCurrentSelected(txts.getSelectedIndex());
//            	  System.out.println(txts.getSelectedIndex());
              }
			}
		});
	
	}
	
	public void initSaveAndRead() {
		saveAndRead=new SaveAndRead();
	}
	
	public void SaveWhenClosed() {
		for (int i = 0; i < txts.getNumberOfItem(); i++) {
			Integer temp=i;
			saveAndRead.save(temp.toString()+".txt", txts.getItemListCorrespondingStringList()[i]);
		}
		Integer temp=txts.getSelectedIndex();
		saveAndRead.save(temp.toString()+".txt", txtArea.getTxtArea().getText());
	}
	
	public void readWhenOpen() {
		for (int i = 0; i < txts.getNumberOfItem(); i++) {
			Integer temp=i;
			txts.setItemCorrespondingString(saveAndRead.read(temp.toString()+".txt"),i);
		}
		txtArea.getTxtArea().setText(txts.getItemListCorrespondingStringList()[txts.getSelectedIndex()]);
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
