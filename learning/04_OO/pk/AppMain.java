package pk;
/**
 * ����ģ����Ϸ����ҵ���߼���Ĵ���
 * @author �Ͼ�ѧ�á���ͷ
 * @version 1.0
 * @date 2017��8��5�� ����2:54:54
 * @copyright �Ͼ�ѧ��
 * @remarks TODO
 *
 */
public class AppMain {

	public static void main(String[] args) {
		Hero cao = new Warrior(1, "�ܲ�", 0, 0);
		
		
//		Hero cao2 = cao;
//		Hero liu =new Warrior(2,"����",1,1);
//		int before=cao.hashCode();
//		cao=liu;
//		int after=cao.hashCode();
//		if (cao2.getName().equals("�ܲ�") && before!=after) {
//			System.out.println("heroCaoָ����ڴ�ռ�ʵ���ϲ�û�иı䣬ֻ��heroCao���ָ�����");
//		}
		
		
		Castle castle = new Castle("��ɯ�ű�", 120, 120, 750);
		
		
		// heroC ���� warrior �еġ�aTest()��,˵�� heroC ���� hero �࣬�������� warrior ��
		//heroC
		cao.PK(castle);
		castle.attack(cao);

	}

}
