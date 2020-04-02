package keyboard;
 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
 
class MyKeyHandle extends JFrame implements KeyListener {
	private JTextArea text = new JTextArea();
 
	public MyKeyHandle() {
		super.setTitle("Crystal");
		JScrollPane pane = new JScrollPane(text);// ���������
		pane.setBounds(5, 5, 300, 200);
		super.add(pane);// ����������
		text.addKeyListener(this);// ����key����
		super.setSize(310, 210);// ���ô���
		super.setVisible(true);// ��ʾ����
		super.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				System.exit(1);// ϵͳ�˳�
			}
		});
 
	}
 
	public void keyPressed(KeyEvent e) {
		text.append("����" + KeyEvent.getKeyText(e.getKeyCode()) + "������\n");
	}
 
	public void keyReleased(KeyEvent e) {
		text.append("����" + KeyEvent.getKeyText(e.getKeyCode()) + "���ɿ�\n");
	}
 
	public void keyTyped(KeyEvent e) {
		text.append("�����������" + e.getKeyChar() + "\n");
	}
}
 
public class KeyListenerDemo {
	public static void main(String[] args) {
		new MyKeyHandle();
	}
}