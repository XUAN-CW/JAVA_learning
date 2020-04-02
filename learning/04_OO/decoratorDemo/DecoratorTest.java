package decorator_;
import java.io.FileNotFoundException;

/**
 * 使用装饰器模式的场合
 * 1、当我们需要在不影响其他对象的情况下，以动态、透明的方式为对象添加功能（扩展方法的实现）
 * 2、当不适合使用继承，但是又想进行方法的扩展时
 */
public class DecoratorTest {

	public static void main(String[] args) throws FileNotFoundException  {
		//创建要被装饰的原始对象
		Component component = new  TrueComponent();		//【component】多态 - 重写父类方法
		//为原始对象透明的增加功能
		ComponentImplA componentA = new ComponentImplA(component);//【componentA】多态 - 重写父类方法
		componentA.read();
		
		System.out.println("");
		ComponentImplB componentB = new ComponentImplB(component);
		componentB.read();
		
		System.out.println("");
		ComponentImplB componentB_A = new ComponentImplB(componentA);
		componentB_A.read();
	}

}
