package polymorphism;

public abstract class Actor {//��һ�����ǳ������ʱ�򣬾Ͳ���ʹ��new��ʵ�����ˣ�--�������������ĸ��࣡
	private String name;
	

	/**
	 * ��Ա�ı��ݷ���
	 */
	public void performs(){
		System.out.println("��Ա" + name + "���ڱ��ݾ��ʵĽ�Ŀ");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Actor(){
		
	}
	
	public Actor(String name){
		setName(name);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
