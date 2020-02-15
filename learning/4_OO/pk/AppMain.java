package pk;
/**
 * 用来模拟游戏核心业务逻辑层的代码
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月5日 下午2:54:54
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class AppMain {

	public static void main(String[] args) {
		Hero cao = new Warrior(1, "曹操", 0, 0);
		
		
//		Hero cao2 = cao;
//		Hero liu =new Warrior(2,"刘备",1,1);
//		int before=cao.hashCode();
//		cao=liu;
//		int after=cao.hashCode();
//		if (cao2.getName().equals("曹操") && before!=after) {
//			System.out.println("heroCao指向的内存空间实际上并没有改变，只是heroCao这个指针变了");
//		}
		
		
		Castle castle = new Castle("温莎古堡", 120, 120, 750);
		
		
		// heroC 中无 warrior 中的【aTest()】,说明 heroC 属于 hero 类，而不属于 warrior 类
		//heroC
		cao.PK(castle);
		castle.attack(cao);

	}

}
