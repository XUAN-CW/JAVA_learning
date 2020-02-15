package modelDemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 * ��Ϸ����
 * @author �Ͼ�ѧ�á���ͷ
 * @version 1.0
 * @date 2017��7��10�� ����6:29:35
 * @copyright �Ͼ�ѧ��
 * @remarks TODO
 *
 */
public class GameFrame extends JFrame implements ImageObserver{
	/** �μ���Ϸ������Ӣ�۶��� */
	private Hero hero1 = null;
	private Hero hero2 = null;
	/** "KO"ͼƬ���� */
	private Image koImage;
	/** ʤ���߶��� */
	private Hero winner = null;
	
	public GameFrame(Hero hero1, Hero hero2) throws IOException{
		this.hero1 = hero1;
		this.hero2 = hero2;
		this.hero1.setImage(new ImageIcon("SourceFolder/modelDemo/��.png").getImage());
		this.hero2.setImage(new ImageIcon("SourceFolder/modelDemo/��.png").getImage());
		koImage = new ImageIcon("images/ko.png").getImage();
		
		/*** 
		 * �����û��ڴ˴����Ϸ��� "close" ʱĬ��ִ�еĲ���������ָ������ѡ��֮һ��
		   1��DO_NOTHING_ON_CLOSE���� WindowConstants �ж��壩����ִ���κβ�����
		   	  Ҫ���������ע��� WindowListener ����� windowClosing �����д���ò�����
		   2��HIDE_ON_CLOSE���� WindowConstants �ж��壩������������ע��� WindowListener ������Զ����ظô��塣
		   3��DISPOSE_ON_CLOSE���� WindowConstants �ж��壩������������ע�� WindowListener �Ķ�����Զ����ز��ͷŸô��塣
		   4��EXIT_ON_CLOSE���� JFrame �ж��壩��ʹ�� System exit �����˳�Ӧ�ó��򡣽���Ӧ�ó�����ʹ�á� 
		  
		 * Ĭ������£���ֵ������Ϊ HIDE_ON_CLOSE
		   Ҳ����˵û�����õĻ�,Ĭ�ϵ�ر�ʱֻ�����ش���,�ں�̨�����л����Կ���  
		   ���ð�"X"��ťʱ��Ķ�����һ�㶼���������˳������൱����System.exit(0);�Ķ���
		   ���û��仰�����㿴����ûӰ�졭����ô�������������ɡ���������ŵĻ�~�����ע�͵���䣬Ȼ��򿪡��رա�
		   ����������ٴΡ�����ϲ�㣬�����ˡ��� 
		 **/
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setTitle("ʾ����ģ��ģʽ��Ӧ��" + "--����Ӣ����ࣺ" + hero1.getDistance(hero1.getX(), hero1.getY(), hero2.getX(), hero2.getY()));
		initComponents();
		setSize(800, 600);		
		setVisible(true);
	}

	private void initComponents() throws IOException {	
		//�ֱ���������ק�͵����¼�
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				super.mouseDragged(e);
				//�ж����������Ƿ���ĳ��Ӣ�۵�ͼƬ��Χ�ڣ�ͼƬ����Ĭ��Ϊ120��
				if(e.getX() < hero1.getX() + 120 && e.getY() < hero1.getY() + 120){
					hero1.setX(hero1.getX() + (e.getX() - hero1.getX()));
					hero1.setY(hero1.getY() + (e.getY() - hero1.getY()));					
				}
				else if(e.getX() < hero2.getX() + 120 && e.getY() < hero2.getY() + 120){
					hero2.setX(hero2.getX() + (e.getX() - hero2.getX()));
					hero2.setY(hero2.getY() + (e.getY() - hero2.getY()));
				}
				setTitle("����Ӣ����ࣺ" + hero1.getDistance(hero1.getX(), hero1.getY(), hero2.getX(), hero2.getY()));
				repaint();//�Զ�����paint()�ػ����
			}

		});
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getX() < hero1.getX() + 120 && e.getY() < hero1.getY() + 120){
					//Ӣ��2�ȹ���Ӣ��1
					hero2.PK(hero1);
				}
				else if(e.getX() < hero2.getX() + 120 && e.getY() < hero2.getY() + 120){
					hero1.PK(hero2);	
				}
				if(hero1.getHp() <= 0){
					winner = hero2;
				}else if(hero2.getHp() <= 0){
					winner = hero1;
				}
				repaint();
			}
		});
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//����Ӣ�۵�ͼƬ
		g.drawImage(hero1.getImage(), hero1.getX(), hero1.getY(), this);
		g.drawImage(hero2.getImage(), hero2.getX(), hero2.getY(), this);
		
		//����Ѫ��
		g.setColor(Color.RED);
		g.drawRect(50, 50, 300, 25);
		g.drawImage(koImage, 360, 50, this);
		g.drawRect(425, 50, 300, 25);
		g.setColor(Color.YELLOW);
		g.fillRect(51, 51, (int)(298 * (hero1.getHp() * 1.0 / hero1.getMaxHp())), 23);
		//���Ƶ�Ѫʱ���Ӿ�Ч���Ǵ������Ҽ�Ѫ��������ʧȥ�ĳ���
		int lostWidth = 298 - (int)(298 * (hero2.getHp() * 1.0 / hero2.getMaxHp()));
		//�����ε�x�������ʧȥ�ĳ��ȣ����������Ǵ������ҵ�Ѫ��
		g.fillRect(426 + lostWidth, 51, (int)(298 * (hero2.getHp() * 1.0 / hero2.getMaxHp())), 23);

		g.setFont(new Font("΢���ź�", Font.BOLD, 24));
		if(winner != null){
			g.setColor(Color.red);
			g.drawString(winner.getName() + "ʤ����", 400, 500);
		}else{
			//������ʾ����
			g.setColor(Color.BLACK);			
			g.drawString("����ͷ�񹥻��Է���", 400, 500);
		}
		
	}
		

	public static void main(String[] args) throws IOException {
		Hero hero1 = new Warrior(10000, "����", 150, 200);
		Hero hero2 = new Magical(30000, "����", 500, 450, 200);
		new GameFrame(hero1, hero2);

	}

}
