package polymorphism;

import java.io.IOException;
import java.util.Properties;

public class ChunWanTest {

	public static void main(String[] args) 
	{
		Director zhang = new Director();	
		Singer song = new Singer("����Ӣ");
		Dancer yang = new Dancer("����Ƽ");
		CrosstalkActor feng = new CrosstalkActor("�빮");
		zhang.action(song);	
		zhang.action(yang);
		zhang.action(feng);
		
		
		
	}
}







