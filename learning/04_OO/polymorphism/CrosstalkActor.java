package polymorphism;

public class CrosstalkActor extends Actor{
	
	
	@Override
	public void performs() {
		System.out.println(getName() + "现在相声不景气啦，我只能说：想死你们了！");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public CrosstalkActor() {
		super();
	}

	public CrosstalkActor(String name) {
		super(name);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
