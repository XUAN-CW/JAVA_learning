package polymorphism;

public class Director {
	/**
	 * 导演的“Action”方法，让演员就位开始表演节目
	 * @param actor
	 */
	public void action(Actor actor)
	{
		actor.performs();
	}
}
