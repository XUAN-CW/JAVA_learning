package polymorphism;
public class Singer extends Actor {

	
	@Override
	public void performs() {
		System.out.println("�質��Ա" + getName() + "���ڱ��ݸ質��Ŀ�������һ�ʢ���ĵط���");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Singer() {
		super();
	}

	public Singer(String name) {
		super(name);
	}
	
}
