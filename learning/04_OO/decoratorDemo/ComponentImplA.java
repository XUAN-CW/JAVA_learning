package decorator_;
/**
 * װ������ʵ����A
 */
public class ComponentImplA extends Decorator{
	
	public ComponentImplA(Component component) {
		super(component);
	}
	
	@Override
	public void read() {
		//ע�⣺��ԭʼ��read����ǰ�󣬷ֱ�������Զ���ķ���
		//��ʵ���˶�ԭread�����Ĺ�����չ��
		this.extendsReadA();
		super.read();	//ԭʼ��read����
		this.extendsReadB();
	}
	
	private void extendsReadA(){
		System.out.println("ComponentImplAʵ�ֵ���չ������extendsReadA");
	}
	
	private void extendsReadB(){
		System.out.println("ComponentImplAʵ�ֵ���չ������extendsReadB");
	}
}
