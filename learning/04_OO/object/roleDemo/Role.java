package roleDemo;
/**
 * ��Ϸ�Ľ�ɫ��
 * @author �Ͼ�ѧ�á���ͷ
 * @version 1.0
 * @date 2017��6��30�� ����10:45:52
 * @copyright �Ͼ�ѧ��
 * @remarks TODO
 *
 */
public class Role 
{
//	���ƣ�����
//	�ȼ���25
//	ְҵ������ѧ��
//	���ܣ�˫ǹ
	/** ��Ϸ��ɫ���������� */
	public String name;
	/** �ȼ� */
	public int level;
	/** ְҵ */
	public String job;
	
	//Ĭ�Ϲ���
	//û�й��췽������дĬ�Ϲ���Ҳ����
	//ûдĬ�Ϲ������д�˹��췽����Ĭ�Ϲ���ͻᱻ����,�Ͳ��� ��role2.name = "�����";�� ����д��
	//д��Ĭ�Ϲ��죬��д�˹��췽�������൱������
	public Role(){}
	
	/**
	 * ���췽��/������
	 * 1��û�з���ֵ
	 * 2��������������һ��
	 */
	//����ʵ����ʱ���Ӵ˴����룬����ִ�й��췽���е����
	//�й��췽���Ϳ��� ��Role role1 = new Role("����ƽ", 50, "����");�� ������ֵ����Ȼ��ֻ��һ��һ����ֵ
	//�����ڴ����ù��췽����ִ�й��췽���е����
	public Role(String name1, int level1, String job1)
	{
		System.out.println(name + "\t" + level + "\t" + job);
		name = name1;
		level = level1;
		job = job1;	
		System.out.println(name + "\t" + level + "\t" + job);
	}
	
	public void show()
	{
		System.out.println(name + "\t" + level + "\t" + job);
	}
	
	/**
	 * �ͷż���
	 */
	public void doSkill()
	{
		if(name.equals("����"))
		{
			System.out.println("�����ľ��似�ܣ�˫ǹ��̫��");
		}
		else if(name.equals("�����"))
		{
			System.out.println("�԰�����һ����");
		}
		else
		{
			System.out.println(name + ":������һ�Ǳ�ɱ��");
		}
		
	}
	
	
	
	
	
	
	
	
	
	

}
