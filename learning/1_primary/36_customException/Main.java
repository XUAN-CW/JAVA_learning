package customException;
/**
 * ��ʾ�ֶ����׳��쳣
 */
public class Main {
	public static void main(String[] args) {
		Hero hero = new Hero("����");
		try {
			hero.setExp(-1000);
			//�����Ѿ���׽���쳣����������ݾͲ���ִ�У������������辭��ֵΪ��������
			hero.setHealth(40);
			hero.rideHorse();
		} catch (Exception e) {	//��ס��ctrl���������Exception����>��super(message);����>�� detailMessage = message;����>��private String detailMessage;��
			//e.printStackTrace();
			//��ס��ctrl���������getMessage����>��detailMessage����>��private String detailMessage;��
			System.err.print("�����þ���ֵʱ�����쳣��" + e.getMessage());	
		}
		System.out.println("\n��ǰӢ�۵ľ���ֵ��" + hero.getExp());
	}
}
