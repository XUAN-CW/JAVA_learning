package other;


public class Other 
{
	public static void main(String[] args)
	{
		
		/*** ����������Ԫ��ʹ��ǰҪ����ռ� **/
		Malloc[] test4 = new Malloc[3];
		test4[0] = new Malloc();	
		test4[0].temp3 = 4;
		System.out.println(test4[0].temp3);
		
		/*** װ�� **/
		Integer[]  array = new Integer[3];
		array[0] = Integer.valueOf(100);
		System.out.println(array[0]);
		
		/*** ǿ������ת�� */
		double num_double = 2.5;
		int num_int = (int)num_double;		//��ʧ����
		System.out.println("ǿ������ת��:" + num_int);
		int ch = 'A';
		System.out.println(ch);
		System.out.println((char)ch);
		
		/*** ? : */
		int result = 1 > 2 ? 1 : 0;
		System.out.println("? :���㣺" + result);
		
		
		/*** switch-case **/
//		���������Ρ��ַ��͡�String�ͣ���������ʹ��String��
		String switch_String = "NULL";
		switch(switch_String)
		{
		case "NULL":
			System.out.println("NULL��>break ��û��break������ switch-case ��");
			switch_String = "break";
		case "break":
			System.out.println (switch_String);
			break;
		}
		
		/*** ��������� **/
		// [ 0.0 , 1 )
		int  randomNumber = (int)(Math.random() * 10000) % 11 + 5;
		System.out.println ("�����:" + randomNumber);
		
		
		/*** ���� **/
//		 * ���öϵ㣺
//		 		����һ�����˫����ɫ����
//		 		���������Ҽ������ɫ����ѡ�� Toggle Breakpoint
//		 * �������ԣ�
//		 		Debug (С����)
//		 * Variables��
//		 		Window��>Show View��>Other��>Debug��>Variables
		

		/*** sleep **/
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		/*** ʹ��ռλ����һ���ַ��� **/
		String str = String.format("%-10d%d", 20, 25);
		//��ӡ�ַ�������
		System.out.println(str);
		
		
		/*** ���ֲ��� **/
		
	}
	
	/*** ����������Ԫ��ʹ��ǰҪ����ռ� **/
	static class Malloc
	{
		int temp3 = 10;
		int temp4 = 50;
	}
	
	
	
	
	
	
	
	
	
	
	
}
