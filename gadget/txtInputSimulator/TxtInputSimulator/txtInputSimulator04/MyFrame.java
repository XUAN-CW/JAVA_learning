package txtInputSimulator04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


import txtInputSimulator04.MycomboBox;
import txtInputSimulator04.TxtJScrollPane;



public class MyFrame extends JFrame{
	JMenuBar bar=null;
	JMenuItem instruction=null;
	JMenuItem startInput=null;
	
	MycomboBox<String> txts;
	TxtJScrollPane txtArea=null;
	SaveAndRead saveAndRead=null;
	
	public MyFrame() {
		super();
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initMyFrame();
		initBar();
		initStartInputItem();
		initInstructionItem();
		initTxtArea();
		initTxts();
		initSaveAndRead();
		colseListener();
		read();
		
		
		
		
		
	}
	
	private void initMyFrame() {
		setTitle("键盘输入模拟器4.0");
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

	private void initStartInputItem() {
		this.startInput = new JMenuItem("点击此处1秒后输入");
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
	
	public void save() {
		for (int i = 0; i < txts.getNumberOfItem(); i++) {
			Integer temp=i;
			saveAndRead.save(temp.toString()+".txt", txts.getItemListCorrespondingStringList()[i]);
		}
		Integer temp=txts.getSelectedIndex();
		saveAndRead.save(temp.toString()+".txt", txtArea.getTxtArea().getText());
	}
	
	public void read() {
		for (int i = 0; i < txts.getNumberOfItem(); i++) {
			Integer temp=i;
			txts.setItemCorrespondingString(saveAndRead.read(temp.toString()+".txt"),i);
		}
		txtArea.getTxtArea().setText(txts.getItemListCorrespondingStringList()[txts.getSelectedIndex()]);
	}

	public void colseListener() {
		addWindowListener(new WindowAdapter(){//为了关闭窗口
	    	 public void windowClosing(WindowEvent e){
	    		 System.out.println(111);
	    		 save();
	    		 System.exit(0);
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
