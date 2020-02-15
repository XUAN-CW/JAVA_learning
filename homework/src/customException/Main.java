package customException;
/**
 * 演示手动的抛出异常
 */
public class Main {
	public static void main(String[] args) {
//		crossTheBorderText c=new crossTheBorderText();
		From0To100Text f=new From0To100Text();
		
//		try {
//			c.inputNumber();
//			f.inputNumber();
//		} catch (Exception e) {
//			System.err.print( e.getMessage());	
//		}
		
		try {
//			c.inputNumber();
			f.inputNumber();
		} catch (Exception e) {
			System.err.print( e.getMessage());	
		}
		
		
		
	}
}
