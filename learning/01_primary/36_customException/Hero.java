package customException;

public class Hero {
	private String name;
	private long exp;
	private int health;
	
	public Hero(String name){
		setName(name);
	}
	
	
	/*** ���������쳣 **/
	public void setExp(long exp) throws Exception {
	if(exp >= 0)
		this.exp = exp;
	else//��expΪ����ʱ��ǿ���׳��쳣
		//throw new Exception("���鲻Ϊ��");
		throw new LessThanZeroException((int)exp);		//�׳��Զ����쳣
	}
	
	/**
	 * Ӣ�۵������� - ��Ӣ�۵Ľ���ֵ����50ʱ������������
	 * @throws LessThanZeroException 
	 */
	public void rideHorse() throws RideHorseException{
		if(health >= 50)
			System.out.println(name + "���ڿ��ֵ�����");
		else
			throw new RideHorseException(health);
	}
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getExp() {
		return exp;
	}

}
