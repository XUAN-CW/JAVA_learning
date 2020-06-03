package androidCodeEditor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AndroidCodeEditor extends JFrame{
	public JPanel txtPanel=null;
	public	JTextArea txtArea=null;
	
	public  AndroidCodeEditor (){
			super();
			setTitle("安卓代码整理");
			setBounds(100, 100, 450, 300);
			setLocationRelativeTo(null);	//窗体居中出现
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			setResizable(false);	//不可缩放 
			
			
			
			/** 文本区面板 */
			 txtArea = new JTextArea(10, 15); 		// 创建一个 5 行 10 列的文本区域
			txtArea.setLineWrap(true);				// 设置自动换行
			
			JScrollPane txtSPanel=new JScrollPane();			
			txtSPanel.setViewportView(txtArea);
			
			this.txtPanel=new JPanel(new BorderLayout());
			this.txtPanel.add(txtSPanel);
			
			/** 创建可滑动的文本面板 */
			getContentPane().add(txtPanel);
			
			/** 菜单栏 */
			JMenuBar bar = new JMenuBar();	// JMenuBar是放菜单的母版,又称为菜单栏
			setJMenuBar(bar);		// 将菜单栏对象放在窗体的菜单栏中
			JMenuItem startInput = new JMenuItem("整理");
			startInput.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String content= txtArea.getText();
					content=content.replaceAll("keywordstyle", "");
					content=content.replaceAll("\\n\\w+", "\n");
					txtArea.setText(content.substring(2, content.length()));
				}

			});
			bar.add(startInput);
			
			setVisible(true);
			
		}
	
    public static void main(String[] args) {
    	new AndroidCodeEditor();
	    
   }
}
