package polymorphism;

public class Director {
	/**
	 * ���ݵġ�Action������������Ա��λ��ʼ���ݽ�Ŀ
	 * @param actor
	 */
	public void action(Actor actor)
	{
		actor.performs();
	}
}
