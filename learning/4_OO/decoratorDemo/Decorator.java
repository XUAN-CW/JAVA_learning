package decorator_;
/**
 * װ�������࣬����Ϊ���������ʵ�ֹ��ܵ���չ
 */
public class Decorator extends Component{
	private Component component;
	
	public Decorator(Component component) {
		this.component = component;		//����ġ�component���Ѿ�����д��
	}

	@Override
	public void read() {
		//ע�⣺�۲�˭����ʵ����read����
		//������ת����component����ת���󣬾Ϳ���ִ��һЩ��չ������
		component.read();	//ִ������д�˵ġ�component.read();��
	}
	
}
