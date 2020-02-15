package polymorphism;

public class Dancer extends Actor{
	
	
	@Override
	public void performs() {
		System.out.println("舞蹈演员" + getName() + "站在展现她那婀娜多姿的舞蹈");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Dancer() {
		super();
	}

	public Dancer(String name) {
		super(name);
	}
	
	
	
	
	
	
	
}
