package customException;
/**
 * 演示手动的抛出异常
 */
public class Main {
	public static void main(String[] args) {
		Hero hero = new Hero("貂蝉");
		try {
			hero.setExp(-1000);
			//上面已经捕捉到异常，下面的内容就不会执行，用上面的语句设经验值为负数试试
			hero.setHealth(40);
			hero.rideHorse();
		} catch (Exception e) {	//按住【ctrl】点击：【Exception】—>【super(message);】—>【 detailMessage = message;】—>【private String detailMessage;】
			//e.printStackTrace();
			//按住【ctrl】点击：【getMessage】—>【detailMessage】—>【private String detailMessage;】
			System.err.print("在设置经验值时出现异常：" + e.getMessage());	
		}
		System.out.println("\n当前英雄的经验值：" + hero.getExp());
	}
}
