package polymorphism;

import java.io.IOException;
import java.util.Properties;

public class ChunWanTest {

	public static void main(String[] args) 
	{
		Director zhang = new Director();	
		Singer song = new Singer("ËÎ×æÓ¢");
		Dancer yang = new Dancer("ÑîÀöÆ¼");
		CrosstalkActor feng = new CrosstalkActor("·ë¹®");
		zhang.action(song);	
		zhang.action(yang);
		zhang.action(feng);
		
		
		
	}
}







