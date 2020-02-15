package decorator_;
import java.io.FileNotFoundException;

/**
 * ʹ��װ����ģʽ�ĳ���
 * 1����������Ҫ�ڲ�Ӱ���������������£��Զ�̬��͸���ķ�ʽΪ������ӹ��ܣ���չ������ʵ�֣�
 * 2�������ʺ�ʹ�ü̳У�����������з�������չʱ
 */
public class DecoratorTest {

	public static void main(String[] args) throws FileNotFoundException  {
		//����Ҫ��װ�ε�ԭʼ����
		Component component = new  TrueComponent();		//��component����̬ - ��д���෽��
		//Ϊԭʼ����͸�������ӹ���
		ComponentImplA componentA = new ComponentImplA(component);//��componentA����̬ - ��д���෽��
		componentA.read();
		
		System.out.println("");
		ComponentImplB componentB = new ComponentImplB(component);
		componentB.read();
		
		System.out.println("");
		ComponentImplB componentB_A = new ComponentImplB(componentA);
		componentB_A.read();
	}

}
