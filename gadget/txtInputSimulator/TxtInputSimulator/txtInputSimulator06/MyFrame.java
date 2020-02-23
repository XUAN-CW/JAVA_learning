package txtInputSimulator06;

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
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

//import sun.util.logging.resources.logging;
//import sun.util.logging.resources.logging;
//import sun.util.logging.resources.logging;
import test.Send;
import txtInputSimulator06.MycomboBox;
import txtInputSimulator06.Myrobot;
import txtInputSimulator06.SaveAndRead;
import txtInputSimulator06.TxtJScrollPane;



public class MyFrame extends JFrame implements Runnable{
	JMenuBar bar=null;
	JMenuItem instruction=null;
	JMenuItem startInput=null;
	JMenuItem stopInputItem=null;
	
	MycomboBox<String> txts;
	TxtJScrollPane txtArea=null;
	SaveAndRead saveAndRead=null;
	
	Myrobot myrobot=null;
	
	Client client=null;
	
	public MyFrame() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		initMyFrame();
		initBar();
		initMyRobot();
		initStartInputItem();
		initInstructionItem();
		initInternetHelp();
		initTxtArea();
		initTxts();
		initSaveAndRead();
		colseListener();
		initClient();
		readWhenOpen();
	}
	
	
	
	private void initMyFrame() {
		setTitle("��������ģ����6");
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

	public void initMyRobot() {
			try {
			myrobot=new Myrobot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
	}
	
	private void initStartInputItem() {	
		this.startInput = new JMenuItem("����˴�1�������");
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
				// ֻ����ѡ�е�״̬
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
		
		client.readAccountAndPassword();
	}
	
	public void colseListener() {
		addWindowListener(new WindowAdapter(){//Ϊ�˹رմ���
	    	 public void windowClosing(WindowEvent e){
	    		 SaveWhenClosed();
//	    		 System.out.println(client.getAccount()+"---"+client.getPassword());
	    		 client.saveAccountAndPassword();
	    		 System.exit(0);
	    	 }
	      });
		
	}
	
	public void initInternetHelp() {
		/** ������һ���˵����� */
		JMenu menu1 = new JMenu("�˺�");							//JMenu menu1
		
		JMenuItem loggingItem = new JMenuItem("�˺Ź���");			//JMenuItem menuItem1_1		=> ����ĩ�ˣ�������Ҷ�ӽ��
		loggingItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if (client.getAccount().equals("")) {
					loggingJf();
				}
				else {
					logOut();
				}
			}
		});
		
		JMenuItem uploading = new JMenuItem("�ϴ�");			//JMenuItem menuItem1_1		=> ����ĩ�ˣ�������Ҷ�ӽ��
		uploading.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if (client.getAccount().equals("")) {
					JOptionPane.showMessageDialog(null, "���ȵ�¼");
				}
				else {
					upload();
				}
			}
		});
		
		JMenuItem download = new JMenuItem("����");			//JMenuItem menuItem1_1		=> ����ĩ�ˣ�������Ҷ�ӽ��
		download.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if (client.getAccount().equals("")) {
					JOptionPane.showMessageDialog(null, "���ȵ�¼");
				}
				else {
					download();
				}
			}
		});
		
		menu1.add(loggingItem);
		menu1.add(uploading);
		menu1.add(download);
		bar.add(menu1);
	}
	
	public void loggingJf() {
		LoggingJFrame loggingJFrame = new LoggingJFrame();
		loggingJFrame.loggingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!loggingJFrame.accountTextField.getText().equals("") &&
						!loggingJFrame.passwordTextField.getText().equals("")) {
					String outcome=client.logging(loggingJFrame.accountTextField.getText(),
							loggingJFrame.passwordTextField.getText());
					if (outcome.equals(client.wrongPassword)) {
						JOptionPane.showMessageDialog(null, "�������");
					}
					if (outcome.equals(client.accountDoesNotExist)) {
						JOptionPane.showMessageDialog(null, "�˻�������");
					}
					if (outcome.equals(client.loginSuccessfully)) {
						JOptionPane.showMessageDialog(null, "��¼�ɹ�");
						loggingJFrame.dispose();
					}
					if (outcome.equals(client.connectionFail)) {
						JOptionPane.showMessageDialog(null, "���������ӻ򿪷���Ա��ɾ����·");
					}
//					JOptionPane.showMessageDialog(null, outcome);
				}
			}
		});
		
		loggingJFrame.registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String outcome=client.createAccount(loggingJFrame.accountTextField.getText(), loggingJFrame.passwordTextField.getText());
				JOptionPane.showMessageDialog(null, outcome);
			}
		});
	}
	
	public void logOut() {
		HaveLoggedOnJFrame haveLoggedOnJFrame=new HaveLoggedOnJFrame(client.getAccount());
		haveLoggedOnJFrame.logOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				client.setAccount("");
				client.setPassword("");
				haveLoggedOnJFrame.dispose();
				JOptionPane.showMessageDialog(null, "���˳���¼");
			}
		});
	}
	
	public void upload() {
		StringBuffer sBuffer=new StringBuffer("");
		for (int i = 0; i < txts.getNumberOfItem(); i++) {
			if (txts.getItemListCorrespondingStringList()[i]==null||txts.getItemListCorrespondingStringList()[i].equals("")) {
				sBuffer.append(client.filler);
			}
			else {
				sBuffer.append(txts.getItemListCorrespondingStringList()[i]);
			}
			sBuffer.append(client.txtDivider);
		}
		
		System.out.println(sBuffer);
		client.setUploadtxt(sBuffer.toString());
		String outcome=client.upload(client.getAccount());
		JOptionPane.showMessageDialog(null, outcome);
	}
	
	public void download() {
		String download_txt=client.download(client.getAccount());
		if (download_txt.equals(client.connectionFail)) {
			JOptionPane.showMessageDialog(null,client.connectionFail );
		}
		else {
			txts.setItemCorrespondingStringList(download_txt.split(client.txtDivider));
			txtArea.getTxtArea().setText(txts.getItemListCorrespondingStringList()[txts.getSelectedIndex()]);
		}
	}
	
	
	public void initClient() {
		client=new Client();
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



	@Override
	public void run() {
		initClient();
	}

	
	
	
	
	
	
}
