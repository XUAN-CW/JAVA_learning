package customException;

public class Hero {
	private String name;
	private long exp;
	private int health;
	
	public Hero(String name){
		setName(name);
	}
	
	
	/*** 经验设置异常 **/
	public void setExp(long exp) throws Exception {
	if(exp >= 0)
		this.exp = exp;
	else//当exp为负数时，强制抛出异常
		//throw new Exception("经验不为负");
		throw new LessThanZeroException((int)exp);		//抛出自定义异常
	}
	
	/**
	 * 英雄的骑马方法 - 当英雄的健康值低于50时，不允许骑马
	 * @throws LessThanZeroException 
	 */
	public void rideHorse() throws RideHorseException{
		if(health >= 50)
			System.out.println(name + "正在快乐地骑马！");
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
